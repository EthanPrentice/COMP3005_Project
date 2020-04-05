package inserts.create_purchase_order;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class InsertPurchaseOrder extends Update {

    public InsertPurchaseOrder(Connection conn, Integer quantity, Integer pricePerUnit) throws SQLException {
        super(conn, "create_purchase_order/insert_purchase_order.sql");
        Date dateOrdered = new Date(System.currentTimeMillis());
        setParams(dateOrdered, quantity, pricePerUnit, false);
    }


}
