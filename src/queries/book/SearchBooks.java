package queries.book;

import adt.sql.BuildableQuery;
import adt.sql_tables.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchBooks extends BuildableQuery<ArrayList<Book>> {

    public SearchBooks(Connection conn, String searchTerm) throws SQLException {
        super(conn, "book/search_books.sql");
        build(searchTerm, searchTerm, searchTerm, searchTerm);
    }

    @Override
    public ArrayList<Book> get() throws SQLException {
        ResultSet rs = execute();
        ArrayList<Book> books = new ArrayList<>();

        while (rs.next()) {
            books.add(new Book(rs));
        }

        return books;
    }
}
