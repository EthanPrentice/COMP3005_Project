package inserts.create_user;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUserShipping extends Insert {

    public InsertUserShipping(Connection conn, Integer shippingInfoId, Integer userId) throws SQLException {
        super(conn, "create_user/insert_user_shipping.sql");
        setParams(shippingInfoId, userId);
    }

}