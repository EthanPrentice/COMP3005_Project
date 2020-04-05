package updates.create_order_from_cart;

import adt.sql.MultiUpdate;
import adt.sql_tables.CartItem;
import adt.sql_tables.User;
import queries.GetCartOwner;
import queries.GetItemsInCart;
import updates.clear_cart.ClearCart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateOrderFromCart implements MultiUpdate {

    private Connection conn;
    private GetItemsInCart getItemsInCart;
    private ClearCart clearCartUpdate;
    private GetCartOwner getCartOwner;

    public CreateOrderFromCart(Connection conn, Integer cartId) throws SQLException {
        this.conn = conn;

        getItemsInCart = new GetItemsInCart(conn, cartId);
        clearCartUpdate = new ClearCart(conn, cartId);
        getCartOwner = new GetCartOwner(conn, cartId);
    }


    private int createOrder() throws SQLException, IllegalStateException {
        // create an empty order
        CreateOrder createOrder = new CreateOrder(conn);
        createOrder.executeUpdate(false);
        ResultSet generatedKeys = createOrder.getGeneratedKeys();

        int orderId;
        if (generatedKeys.next()) {
            orderId = generatedKeys.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not create a new order.  Rolling back.");
        }

        // associate order with the user
        User cartOwner = getCartOwner.getOwner();
        if (cartOwner == null) {
            throw new IllegalStateException("Cannot create order when no user is logged in.");
        }
        InsertUserOrder insertUserOrder = new InsertUserOrder(conn, orderId, cartOwner.getId());
        insertUserOrder.executeUpdate(false);

        return orderId;
    }

    private void addItems(int orderId) throws SQLException {
        InsertItemInOrder insertItemInOrder;
        InsertBookSold insertBookSold;
        InsertSoldItem insertSoldItem;

        ArrayList<CartItem> items = getItemsInCart.getItems();

        int soldItemId;
        ResultSet generatedKeys;
        for (CartItem item : items) {
            // insert sold item
            insertSoldItem = new InsertSoldItem(conn, item.getBook().getPrice(), item.getQuantity());
            insertSoldItem.executeUpdate(false);

            generatedKeys = insertSoldItem.getGeneratedKeys();
            if (generatedKeys.next()) {
                soldItemId = generatedKeys.getInt(1);

                // add the sold item to it's relations to the book, and to the order
                insertBookSold = new InsertBookSold(conn, soldItemId, item.getBook().getId());
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

    @Override
    public void executeUpdates() throws SQLException, IllegalStateException {
        int orderId = createOrder();
        addItems(orderId);

        // Delete all CartItems that were in the cart.
        // Their relations will be deleted through cascading
        clearCartUpdate.executeUpdate(false);

        conn.commit();
    }
}
