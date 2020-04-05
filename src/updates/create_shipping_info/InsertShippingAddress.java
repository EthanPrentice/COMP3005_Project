package updates.create_shipping_info;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertShippingAddress extends Update {

    public InsertShippingAddress(Connection conn, Integer shippingInfoId, Integer shippingAddrId) throws SQLException {
        super(conn, "create_shipping_info/insert_shipping_addr.sql");
        setParams(shippingInfoId, shippingAddrId);
    }

}
