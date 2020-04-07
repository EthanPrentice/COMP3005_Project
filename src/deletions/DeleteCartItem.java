package deletions;

import adt.sql.Deletion;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteCartItem extends Deletion {

    public DeleteCartItem(Connection conn, int cartItemId) throws SQLException {
        super(conn, "del_cart_item.sql");
        setParams(cartItemId);
    }

}
