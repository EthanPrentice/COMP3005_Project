package updates.create_order_from_cart;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertItemInOrder extends Update {

    public InsertItemInOrder(Connection conn, Integer soldItemId, Integer orderId) throws SQLException {
        super(conn, "create_order_from_cart/insert_item_in_order.sql");
        setParams(soldItemId, orderId);
    }

}
