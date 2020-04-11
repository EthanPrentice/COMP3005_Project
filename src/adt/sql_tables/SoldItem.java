package adt.sql_tables;

import queries.order.GetSoldItemBook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SoldItem extends SQLObject {

    private Book book;
    private float pricePerUnit;
    private float publisherRate;
    private int quantity;

    public SoldItem(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("sold_item_id");
        book = new Book(rs);
        pricePerUnit = rs.getFloat("price_per_unit");
        publisherRate = rs.getFloat("publisher_rate");
        quantity = rs.getInt("quantity");
    }

    public Book getBook(Connection conn) throws SQLException {
        GetSoldItemBook getBook = new GetSoldItemBook(conn, id);
        return getBook.get();
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public float getPublisherRate() {
        return publisherRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getSubtotal() {
        return pricePerUnit * quantity;
    }


    public String toString(Connection conn) throws SQLException {
        String formatStr = "%-60s, Quantity: %3d";
        Book book = getBook(conn);
        return String.format(formatStr, book.getTitle(), quantity);
    }

}
