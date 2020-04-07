package queries.cart;

import adt.sql.BuildableQuery;
import adt.sql_tables.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCartItemBook extends BuildableQuery<Book> {

    public GetCartItemBook(Connection conn, int cartItemId) throws SQLException {
        super(conn, "cart/get_cart_item_book.sql");
        build(cartItemId);
    }

    @Override
    public Book get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new Book(rs);
        }

        return null;
    }
}
