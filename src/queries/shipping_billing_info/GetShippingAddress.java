package queries.shipping_billing_info;

import adt.sql.BuildableQuery;
import adt.sql_tables.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetShippingAddress extends BuildableQuery<Address> {

    public GetShippingAddress(Connection conn, int shippingInfoId) throws SQLException {
        super(conn, "shipping_billing_address/get_shipping_addr.sql");
        build(shippingInfoId);
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
