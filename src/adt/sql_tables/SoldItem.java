package adt.sql_tables;

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

    @Override
    public String toString() {
        String formatStr = "SoldItem(%3d, %3.2f, %2d, %s";
        return String.format(formatStr, id, pricePerUnit, quantity, book.toString());
    }

}
