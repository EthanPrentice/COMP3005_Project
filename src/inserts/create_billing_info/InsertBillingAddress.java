package inserts.create_billing_info;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBillingAddress extends Update {

    public InsertBillingAddress(Connection conn, Integer billingInfoId, Integer billingAddrId) throws SQLException {
        super(conn, "create_billing_info/insert_billing_addr.sql");
        setParams(billingInfoId, billingAddrId);
    }

}
