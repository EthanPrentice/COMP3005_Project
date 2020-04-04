package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cart extends SQLObject {

    private Integer id;
    private ArrayList<CartItem> items;
    private User ownedBy;

    Cart() {
        items = new ArrayList<>();
        ownedBy = null;
    }

    Cart(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("cart_id");
    }

    Cart(ArrayList<CartItem> items) {
        this.items = items;
    }

    Cart(ArrayList<CartItem> items, User ownedBy) {
        this(items);
        this.ownedBy = ownedBy;
    }

    public void addItem(CartItem item) {
        items.add(item);
        // TODO: Add item to database
    }

    public void removeItem(int itemId) {
        for (int i = 0; i < items.size(); ++i) {
            if (itemId == items.get(i).getId()) {
                items.remove(i);
                // TODO: Remove item from database
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public User getOwnedBy() {
        return ownedBy;
    }

}
