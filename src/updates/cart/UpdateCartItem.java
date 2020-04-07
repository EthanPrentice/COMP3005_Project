package updates.cart;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class UpdateCartItem extends Update {

    public UpdateCartItem(Connection conn, int cartItemId, int quantity) throws SQLException {
        super(conn, "cart/update_cart_item.sql");
        setParams(quantity, cartItemId);
    }

}
