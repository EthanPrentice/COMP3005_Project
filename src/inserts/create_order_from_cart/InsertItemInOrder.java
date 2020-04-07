package inserts.create_order_from_cart;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertItemInOrder extends Insert {

    public InsertItemInOrder(Connection conn, Integer soldItemId, Integer orderId) throws SQLException {
        super(conn, "create_order_from_cart/insert_item_in_order.sql");
        setParams(soldItemId, orderId);
    }

}
