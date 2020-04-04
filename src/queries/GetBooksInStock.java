package queries;

import adt.sql.OrderBy;
import adt.sql.Query;
import adt.sql_tables.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetBooksInStock extends Query {

    public GetBooksInStock(Connection conn) throws SQLException {
        super(conn, "get_books_in_stock.sql");
    }

    public GetBooksInStock(Connection conn, OrderBy orderBy) throws SQLException {
        super(conn, "get_books_in_stock.sql", orderBy);
    }

    public ArrayList<Book> getBooks() throws SQLException {
        ResultSet rs = execute();
        ArrayList<Book> books = new ArrayList<>();

        while (rs.next()) {
            books.add(new Book(rs));
        }

        return books;
    }


}
