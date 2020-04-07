package inserts.add_cart_item;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBookInItem extends Insert {

    public InsertBookInItem(Connection conn, int cartItemId, int bookId) throws SQLException {
        super(conn, "add_cart_item/insert_book_in_item.sql");
        setParams(cartItemId, bookId);
    }


}
