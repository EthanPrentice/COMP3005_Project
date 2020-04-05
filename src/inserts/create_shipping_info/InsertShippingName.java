package inserts.create_shipping_info;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertShippingName extends Update {

    public InsertShippingName(Connection conn, Integer shippingInfoId, Integer nameId) throws SQLException {
        super(conn, "create_shipping_info/insert_shipping_name.sql");
        setParams(shippingInfoId, nameId);
    }


}
