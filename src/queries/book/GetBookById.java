package queries.book;

import adt.sql.BuildableQuery;
import adt.sql_tables.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBookById extends BuildableQuery<Book> {

    public GetBookById(Connection conn, int bookId) throws SQLException {
        super(conn, "book/get_book_by_id.sql");
        build(bookId);
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
