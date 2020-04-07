package inserts.create_billing_info;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBillingName extends Insert {

    public InsertBillingName(Connection conn, Integer billingInfoId, Integer nameId) throws SQLException {
        super(conn, "create_billing_info/insert_billing_name.sql");
        setParams(billingInfoId, nameId);
    }


}
