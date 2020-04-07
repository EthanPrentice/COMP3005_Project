package inserts.create_order_from_cart;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBookSold extends Insert {

    public InsertBookSold(Connection conn, Integer soldItemId, Integer bookId) throws SQLException {
        super(conn, "create_order_from_cart/insert_book_sold.sql");
        setParams(soldItemId, bookId);
    }

}
