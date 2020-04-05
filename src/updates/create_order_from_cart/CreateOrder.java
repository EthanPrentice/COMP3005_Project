package updates.create_order_from_cart;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CreateOrder extends Update {

    public CreateOrder(Connection conn) throws SQLException {
        super(conn, "create_order_from_cart/create_order.sql");
        setParams(new Timestamp(System.currentTimeMillis()), null, null, false);
    }

}
