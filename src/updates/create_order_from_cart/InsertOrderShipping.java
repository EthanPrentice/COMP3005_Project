package updates.create_order_from_cart;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertOrderShipping extends Update {

    public InsertOrderShipping(Connection conn, Integer orderId, Integer shippingInfoId) throws SQLException {
        super(conn, "create_order_from_cart/insert_order_shipping.sql");
        setParams(orderId, shippingInfoId);
    }
    
}
