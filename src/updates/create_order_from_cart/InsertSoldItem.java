package updates.create_order_from_cart;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertSoldItem extends Update {

    public InsertSoldItem(Connection conn, Float pricePerUnit, Integer quantity) throws SQLException {
        super(conn, "create_order_from_cart/insert_sold_item.sql");
        setParams(pricePerUnit, quantity);
    }
}
