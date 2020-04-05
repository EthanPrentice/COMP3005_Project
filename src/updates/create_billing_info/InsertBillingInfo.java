package updates.create_billing_info;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBillingInfo extends Update {

    public InsertBillingInfo(Connection conn) throws SQLException {
        super(conn, "create_billing_info/insert_billing_info.sql");
    }

}
