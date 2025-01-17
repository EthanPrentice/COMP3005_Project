package inserts.create_user;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUserCart extends Insert {

    public InsertUserCart(Connection conn, Integer userId, Integer cartId) throws SQLException {
        super(conn, "create_user/insert_user_cart.sql");
        setParams(userId, cartId);
    }

}
