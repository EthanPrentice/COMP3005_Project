package inserts.create_order_from_cart;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertUserOrder extends Update {

    public InsertUserOrder(Connection conn, Integer orderId, Integer userId) throws SQLException {
        super(conn, "create_order_from_cart/insert_user_order.sql");
        setParams(orderId, userId);
    }


}
