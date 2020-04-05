package inserts.create_user;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertCart extends Update {
    public InsertCart(Connection conn) throws SQLException {
        super(conn, "create_user/insert_cart.sql");
    }
}
