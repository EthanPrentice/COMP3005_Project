package queries.order;

import adt.sql.BuildableQuery;
import adt.sql_tables.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetSoldItemBook extends BuildableQuery<Book> {

    public GetSoldItemBook(Connection conn, int soldItemId) throws SQLException {
        super(conn, "order/get_sold_item_book.sql");
        build(soldItemId);
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
