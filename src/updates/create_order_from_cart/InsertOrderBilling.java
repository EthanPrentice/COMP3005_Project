package updates.create_order_from_cart;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertOrderBilling extends Update {

    public InsertOrderBilling(Connection conn, Integer orderId, Integer billingInfoId) throws SQLException {
        super(conn, "create_order_from_cart/insert_order_billing.sql");
        setParams(orderId, billingInfoId);
    }

}
