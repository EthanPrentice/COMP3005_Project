package inserts.create_user;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUserPhone extends Insert {

    public InsertUserPhone(Connection conn, Integer phoneId, Integer userId) throws SQLException {
        super(conn, "create_user/insert_user_phone.sql");
        setParams(phoneId, userId);
    }

}

