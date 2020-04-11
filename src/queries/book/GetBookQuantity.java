package queries.book;

import adt.sql.BuildableQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetBookQuantity extends BuildableQuery<Integer> {

    public GetBookQuantity(Connection conn, int bookId) throws SQLException {
        super(conn, "book/get_book_quantity.sql");
        build(bookId);
    }

    @Override
    public Integer get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return rs.getInt("quantity");
        }

        return null;
    }
}
