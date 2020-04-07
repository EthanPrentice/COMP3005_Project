package inserts.add_cart_item;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertCartItem extends Insert {

    public InsertCartItem(Connection conn, int quantity) throws SQLException {
        super(conn, "add_cart_item/insert_cart_item.sql");
        setParams(quantity);
    }
}
