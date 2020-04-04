package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItem extends SQLObject {

    private Integer id;
    private Book book;
    private int quantity;

    CartItem(Book book, int quantity) {
        this.id = null;
        this.book = book;
        this.quantity = quantity;
    }

    CartItem(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("cart_item_id");
        book = new Book(rs);
        quantity = rs.getInt("quantity");
    }

    public Integer getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSubtotal() {
        return book.getPrice() * quantity;
    }

}
