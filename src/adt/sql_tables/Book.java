package adt.sql_tables;

import queries.GetSupplierPricing;
import queries.book.GetBookAuthor;
import queries.book.GetBookQuantity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Book extends SQLObject {

    private String genre;
    private String title;
    private int pageCount;
    private float price;


    public Book(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("book_id");
        genre = rs.getString("genre");
        title = rs.getString("title");
        pageCount = rs.getInt("page_count");
        price = rs.getFloat("price");
    }


    public Book(ResultSet rs, HashMap<String, String> fieldNames) throws SQLException {
        super(rs);

        id = rs.getInt(fieldNames.get("book_id"));
        genre = rs.getString(fieldNames.get("genre"));
        title = rs.getString(fieldNames.get("title"));
        pageCount = rs.getInt(fieldNames.get("page_count"));
        price = rs.getInt(fieldNames.get("price"));
    }

    public Author getAuthor(Connection conn) throws SQLException {
        GetBookAuthor getBookAuthor = new GetBookAuthor(conn, getId());
        return getBookAuthor.get();
    }

    public SupplierPricing getSupplierPricing(Connection conn) throws SQLException {
        GetSupplierPricing getSupplierPricing = new GetSupplierPricing(conn, id);
        return getSupplierPricing.get();
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity(Connection conn) throws SQLException {
        GetBookQuantity getQuantity = new GetBookQuantity(conn, id);
        Integer quantity = getQuantity.get();
        
        if (quantity != null) {
            return quantity;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String formatStr = "Book(%3d, %s, %s, %3d, %3.2f)";
        return String.format(formatStr, id, title, genre, pageCount, price);
    }
}
