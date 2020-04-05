package updates.create_order_from_cart;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBookSold extends Update {

    public InsertBookSold(Connection conn, Integer soldItemId, Integer bookId) throws SQLException {
        super(conn, "create_order_from_cart/insert_book_sold.sql");
        setParams(soldItemId, bookId);
    }

}
