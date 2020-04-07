package inserts.create_order_from_cart;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertOrderShipping extends Insert {

    public InsertOrderShipping(Connection conn, Integer orderId, Integer shippingInfoId) throws SQLException {
        super(conn, "create_order_from_cart/insert_order_shipping.sql");
        setParams(orderId, shippingInfoId);
    }
    
}
