package queries.shipping_billing_info;

import adt.sql.BuildableQuery;
import adt.sql_tables.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBillingAddress extends BuildableQuery<Address> {

    public GetBillingAddress(Connection conn, int billingInfoId) throws SQLException {
        super(conn, "shipping_billing_address/get_billing_addr.sql");
        build(billingInfoId);
    }

    @Override
    public Address get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new Address(rs);
        }

        return null;
    }
}
