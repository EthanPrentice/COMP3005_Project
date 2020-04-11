package queries.shipping_billing_info;

import adt.sql.BuildableQuery;
import adt.sql_tables.PersonName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetShippingName extends BuildableQuery<PersonName> {

    public GetShippingName(Connection conn, int shippingInfoId) throws SQLException {
        super(conn, "shipping_billing_info/get_shipping_name.sql");
        build(shippingInfoId);
    }

    @Override
    public PersonName get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new PersonName(rs);
        }

        return null;
    }
}
