package inserts.create_order_from_cart;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertOrderBilling extends Insert {

    public InsertOrderBilling(Connection conn, Integer orderId, Integer billingInfoId) throws SQLException {
        super(conn, "create_order_from_cart/insert_order_billing.sql");
        setParams(orderId, billingInfoId);
    }

}
