package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Book extends SQLObject {

    private int id;
    private String genre;
    private String title;
    private int pageCount;
    private int price;


    Book(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("book_id");
        genre = rs.getString("genre");
        title = rs.getString("title");
        pageCount = rs.getInt("page_count");
        price = rs.getInt("price");
    }


    Book(ResultSet rs, HashMap<String, String> fieldNames) throws SQLException {
        super(rs);

        id = rs.getInt(fieldNames.get("book_id"));
        genre = rs.getString(fieldNames.get("genre"));
        title = rs.getString(fieldNames.get("title"));
        pageCount = rs.getInt(fieldNames.get("page_count"));
        price = rs.getInt(fieldNames.get("price"));
    }


    public int getId() {
        return id;
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

    public int getPrice() {
        return price;
    }


}
