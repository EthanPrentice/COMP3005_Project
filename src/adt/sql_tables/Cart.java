package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cart extends SQLObject {

    private User ownedBy;

    Cart() {
        id = null;
        ownedBy = null;
    }

    Cart(ResultSet rs) throws SQLException {
        super(rs);
        id = rs.getInt("cart_id");

        // TODO: maybe get this from a query instead of storing it?
        // TODO: can also store and run a query once in constructor since cart should never change owners
        ownedBy = null;
    }

    Cart(User ownedBy) {
        this.ownedBy = ownedBy;
    }

    public void addItem(CartItem item) {
        // TODO: Add item to database
    }

    public void removeItem(int itemId) {
        // TODO: Remove item from database
    }

    public ArrayList<CartItem> getItems() {
        // TODO: implement to run query getting cart items
        return null;
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
