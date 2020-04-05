package inserts.create_user;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUserShipping extends Update {

    public InsertUserShipping(Connection conn, Integer shippingInfoId, Integer userId) throws SQLException {
        super(conn, "create_user/insert_user_shipping.sql");
        setParams(shippingInfoId, userId);
    }

}