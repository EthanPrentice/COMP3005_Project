package adt.sql_tables;

import deletions.DeleteCartItem;
import input.InfoManager;
import inserts.add_cart_item.AddCartItem;
import queries.GetCartOwner;
import queries.cart.GetCart;
import queries.cart.GetCartItems;
import updates.cart.UpdateCartItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart extends SQLObject {

    public Cart(ResultSet rs) throws SQLException {
        super(rs);
        id = rs.getInt("cart_id");
    }

    public void addItem(Connection conn, int bookId, int quantity) throws SQLException {
        ArrayList<CartItem> items = getItems(conn);

        for (CartItem item : items) {
            if (item.getBook(conn).getId() == bookId) {
                UpdateCartItem updateCartItem = new UpdateCartItem(conn, item.getId(), item.getQuantity() + quantity);
                updateCartItem.executeUpdate();
                return;
            }
        }

        AddCartItem addCartItem = new AddCartItem(conn, id, bookId, quantity);
        addCartItem.executeUpdates();
    }

    public void removeItem(Connection conn, int itemIndex) throws SQLException {
        ArrayList<CartItem> items = getItems(conn);
        DeleteCartItem deleteCartItem = new DeleteCartItem(conn, items.get(itemIndex).getId());
        deleteCartItem.executeUpdate();
    }

    public ArrayList<CartItem> getItems(Connection conn) throws SQLException {
        GetCartItems getCartItems = new GetCartItems(conn, id);
        return getCartItems.get();
    }

    public User getOwnedBy(Connection conn) throws SQLException {
        GetCartOwner getCartOwner = new GetCartOwner(conn, id);
        return getCartOwner.get();
    }


    public String toString(Connection conn) throws SQLException {
        ArrayList<CartItem> cartItems = getItems(conn);

        if (cartItems.isEmpty()) {
            return "Cart is empty!";
        }

        StringBuilder sb = new StringBuilder();

        String headerString = "%4s | %-60s | %6s | %8s | %9s\n";
        sb.append(String.format(headerString, "ID", "Book Title", "Price", "Quantity", "Subtotal"));

        float totalPrice = 0;
        float subtotal;
        DecimalFormat decimalFormat = new DecimalFormat("####0.00");
        String formatString = "%4s | %-60s | %6s | %8s | $%8s\n";
        for (int i = 0; i < cartItems.size(); ++i) {
            Book book = cartItems.get(i).getBook(conn);
            String priceString = decimalFormat.format(book.getPrice());

            subtotal = cartItems.get(i).getSubtotal(conn);
            String subtotalString = decimalFormat.format(subtotal);

            totalPrice += subtotal;

            sb.append(String.format(formatString, (i + 1), book.getTitle(), priceString, cartItems.get(i).getQuantity(), subtotalString));
        }

        sb.append(String.format("Total: $%8s", decimalFormat.format(totalPrice)));

        return sb.toString();
    }


}
