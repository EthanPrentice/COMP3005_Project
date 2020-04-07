package inserts.clear_cart;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class ClearCart extends Insert {

    public ClearCart(Connection conn, Integer cartId) throws SQLException {
        super(conn, "clear_cart/delete_cart_items.sql");
        setParams(cartId);
    }

}
