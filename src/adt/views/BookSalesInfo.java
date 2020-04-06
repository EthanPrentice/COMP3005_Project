package adt.views;

import adt.sql_tables.SQLObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSalesInfo extends SQLObject {

    private String bookTitle;
    private int salesQuantity;
    private int salesRevenue;

    public BookSalesInfo(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("book_id");
        bookTitle = rs.getString("title");
        salesQuantity = rs.getInt("quantity_sold");
        salesRevenue = rs.getInt("revenue");
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public int getSalesRevenue() {
        return salesRevenue;
    }
}
