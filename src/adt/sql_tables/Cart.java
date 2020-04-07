package adt.sql_tables;

import deletions.DeleteCartItem;
import inserts.add_cart_item.AddCartItem;
import queries.cart.GetCartItems;
import updates.cart.UpdateCartItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cart extends SQLObject {

    private User ownedBy;

    public Cart(ResultSet rs) throws SQLException {
        super(rs);
        id = rs.getInt("cart_id");

        // TODO: maybe get this from a query instead of storing it?
        // TODO: can also store and run a query once in constructor since cart should never change owners
        ownedBy = null;
    }

    Cart(User ownedBy) {
        this.ownedBy = ownedBy;
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

    public User getOwnedBy() {
        return ownedBy;
    }


    @Override
    public String toString() {
        String formatStr = "Cart(%3d, %s)";
        return String.format(formatStr, id, ownedBy);
    }


}
