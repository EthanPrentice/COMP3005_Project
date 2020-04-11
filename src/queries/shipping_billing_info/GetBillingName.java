package queries.shipping_billing_info;

import adt.sql.BuildableQuery;
import adt.sql_tables.PersonName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBillingName extends BuildableQuery<PersonName> {

    public GetBillingName(Connection conn, int billingInfoId) throws SQLException {
        super(conn, "shipping_billing_info/get_billing_name.sql");
        build(billingInfoId);
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
