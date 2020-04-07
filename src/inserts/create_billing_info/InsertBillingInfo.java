package inserts.create_billing_info;


import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBillingInfo extends Insert {

    public InsertBillingInfo(Connection conn) throws SQLException {
        super(conn, "create_billing_info/insert_billing_info.sql");
    }

}
