package inserts.create_order_from_cart;

import adt.sql.MultiUpdate;
import adt.sql_tables.*;
import queries.GetCartOwner;
import queries.GetItemsInCart;
import inserts.clear_cart.ClearCart;
import inserts.create_billing_info.CreateBillingInfo;
import inserts.create_shipping_info.CreateShippingInfo;
import queries.cart.GetCartItems;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateOrderFromCart implements MultiUpdate {

    private Connection conn;

    private int cartId;

    private Address shippingAddress;
    private Address billingAddress;

    private PersonName shippingName;
    private PersonName billingName;

    private Integer orderId = null;

    public CreateOrderFromCart(Connection conn, Integer cartId, BillingInfo billingInfo, ShippingInfo shippingInfo) throws SQLException {
        this.conn = conn;
        this.cartId = cartId;
        this.billingAddress = billingInfo.getAddress(conn);
        this.shippingAddress = shippingInfo.getAddress(conn);
        this.billingName = billingInfo.getName(conn);
        this.shippingName = shippingInfo.getName(conn);
    }


    public CreateOrderFromCart(Connection conn, Integer cartId, Address billingAddress, PersonName billingName, Address shippingAddress, PersonName shippingName) throws SQLException {
        this.conn = conn;
        this.cartId = cartId;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.billingName = billingName;
        this.shippingName = shippingName;
    }


    private int createOrder() throws SQLException, IllegalStateException {
        // create an empty order
        InsertOrder createOrder = new InsertOrder(conn);
        createOrder.executeUpdate(false);
        ResultSet generatedKeys = createOrder.getGeneratedKeys();

        int orderId;
        if (generatedKeys.next()) {
            orderId = generatedKeys.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert a new order.  Rolling back.");
        }

        // associate order with the user
        GetCartOwner getCartOwner = new GetCartOwner(conn, cartId);
        User cartOwner = getCartOwner.get();
        if (cartOwner == null) {
            conn.rollback();
            throw new IllegalStateException("Cannot create order when no user is logged in.");
        }
        InsertUserOrder insertUserOrder = new InsertUserOrder(conn, orderId, cartOwner.getId());
        insertUserOrder.executeUpdate(false);

        return orderId;
    }

    private void addItems(int orderId) throws SQLException, IllegalStateException {
        InsertItemInOrder insertItemInOrder;
        InsertBookSold insertBookSold;
        InsertSoldItem insertSoldItem;

        GetItemsInCart getItemsInCart = new GetItemsInCart(conn, cartId);
        ArrayList<CartItem> items = getItemsInCart.get();

        if (items.isEmpty()) {
            conn.rollback();
            throw new IllegalStateException("Cannot create an order from an empty cart.");
        }

        int soldItemId;
        ResultSet generatedKeys;
        for (CartItem item : items) {

            Book book = item.getBook(conn);

            // insert sold item
            float publisherRate = book.getSupplierPricing(conn).getPublisherRate();
            insertSoldItem = new InsertSoldItem(conn, book.getPrice(), publisherRate, item.getQuantity());
            insertSoldItem.executeUpdate(false);

            generatedKeys = insertSoldItem.getGeneratedKeys();
            if (generatedKeys.next()) {
                soldItemId = generatedKeys.getInt(1);

                // add the sold item to it's relations to the book, and to the order
                insertBookSold = new InsertBookSold(conn, soldItemId, book.getId());
                insertItemInOrder = new InsertItemInOrder(conn, soldItemId, orderId);

                insertBookSold.executeUpdate(false);
                insertItemInOrder.executeUpdate(false);

            }
            else {
                conn.rollback();
                throw new SQLException("Could not insert SoldItem.  Rolling back.");
            }
        }
    }

    private int addBillingInfo(int orderId) throws SQLException {
        CreateBillingInfo createBillingInfo = new CreateBillingInfo(conn, billingName, billingAddress);
        createBillingInfo.executeUpdates(false);

        int billingInfoId = createBillingInfo.getBillingInfoId();

        InsertOrderBilling insertOrderBilling = new InsertOrderBilling(conn, orderId, billingInfoId);
        insertOrderBilling.executeUpdate(false);

        return billingInfoId;
    }


    private int addShippingInfo(int orderId) throws SQLException {
        CreateShippingInfo createShippingInfo = new CreateShippingInfo(conn, shippingName, shippingAddress);
        createShippingInfo.executeUpdates(false);

        int shippingInfoId = createShippingInfo.getShippingInfoId();

        InsertOrderShipping insertOrderShipping = new InsertOrderShipping(conn, orderId, shippingInfoId);
        insertOrderShipping.executeUpdate(false);

        return shippingInfoId;
    }


    @Override
    public void executeUpdates() throws SQLException, IllegalStateException {
        executeUpdates(true);
    }


    @Override
    public void executeUpdates(boolean commit) throws SQLException, IllegalStateException {
        int orderId = createOrder();
        addItems(orderId);

        addBillingInfo(orderId);
        addShippingInfo(orderId);

        // Delete all CartItems that were in the cart.
        // Their relations will be deleted through cascading
        ClearCart clearCartUpdate = new ClearCart(conn, cartId);
        clearCartUpdate.executeUpdate(false);

        // if successful assign orderId so it can be accessed outside of Insert object
        this.orderId = orderId;

        if (commit) {
            conn.commit();
        }
    }

    public Integer getOrderId() {
        return orderId;
    }
}
