package inserts.create_user;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUser extends Update{

    public InsertUser(Connection conn, String username, String email, String password) throws SQLException {
        super(conn, "create_user/insert_user.sql");
        setParams(username, email, password, false);
    }

}
