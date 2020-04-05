package updates.clear_cart;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class ClearCart extends Update {

    public ClearCart(Connection conn, Integer cartId) throws SQLException {
        super(conn, "clear_cart/delete_cart_items.sql");
        setParams(cartId);
    }

}
