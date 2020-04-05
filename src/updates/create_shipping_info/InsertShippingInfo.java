package updates.create_shipping_info;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertShippingInfo extends Update {

    public InsertShippingInfo(Connection conn) throws SQLException {
        super(conn, "create_shipping_info/insert_shipping_info.sql");
    }

}
