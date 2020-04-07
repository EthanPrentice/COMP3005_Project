package inserts.create_user;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUserBilling extends Insert {

    public InsertUserBilling(Connection conn, Integer billingInfoId, Integer userId) throws SQLException {
        super(conn, "create_user/insert_user_billing.sql");
        setParams(billingInfoId, userId);
    }

}
