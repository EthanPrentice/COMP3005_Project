package queries.book;

import adt.sql.BuildableQuery;
import adt.sql_tables.Author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBookAuthor extends BuildableQuery<Author> {

    public GetBookAuthor(Connection conn, int bookId) throws SQLException {
        super(conn, "book/get_book_author.sql");
        build(bookId);
    }

    @Override
    public Author get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new Author(rs);
        }

        return null;
    }
}
