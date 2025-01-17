package inserts.create_order_from_cart;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertSoldItem extends Insert {

    public InsertSoldItem(Connection conn, Float pricePerUnit, Float publisherRate, Integer quantity) throws SQLException {
        super(conn, "create_order_from_cart/insert_sold_item.sql");
        setParams(pricePerUnit, publisherRate, quantity);
    }
}
