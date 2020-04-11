package adt.sql_tables;

import queries.shipping_billing_info.GetShippingAddress;
import queries.shipping_billing_info.GetShippingName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShippingInfo extends SQLObject {

    public ShippingInfo(ResultSet rs) throws SQLException {
        id = rs.getInt("shipping_info_id");
    }

    public PersonName getName(Connection conn) throws SQLException {
        GetShippingName getName = new GetShippingName(conn, id);
        return getName.get();
    }

    public Address getAddress(Connection conn) throws SQLException {
        GetShippingAddress getAddress = new GetShippingAddress(conn, id);
        return getAddress.get();
    }

    public String toString(Connection conn) throws SQLException {
        return String.format("%s,\n%s", getName(conn).getFull(), getAddress(conn).toString());
    }
}
