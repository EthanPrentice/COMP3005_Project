package inserts.add_cart_item;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertItemInCart extends Insert {

    public InsertItemInCart(Connection conn, int cartItemId, int cartId) throws SQLException {
        super(conn, "add_cart_item/insert_item_in_cart.sql");
        setParams(cartItemId, cartId);
    }
}
