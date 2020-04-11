package adt.sql_tables;

import queries.shipping_billing_info.GetBillingAddress;
import queries.shipping_billing_info.GetBillingName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillingInfo extends SQLObject {

    public BillingInfo(ResultSet rs) throws SQLException {
        id = rs.getInt("billing_info_id");
    }

    public PersonName getName(Connection conn) throws SQLException {
        GetBillingName getName = new GetBillingName(conn, id);
        return getName.get();
    }

    public Address getAddress(Connection conn) throws SQLException {
        GetBillingAddress getAddress = new GetBillingAddress(conn, id);
        return getAddress.get();
    }

    public String toString(Connection conn) throws SQLException {
        return String.format("%s,\n%s", getName(conn).getFull(), getAddress(conn).toString());
    }
}
