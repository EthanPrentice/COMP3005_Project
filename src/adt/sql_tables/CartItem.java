package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItem extends SQLObject {

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

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSubtotal() {
        return book.getPrice() * quantity;
    }

    @Override
    public String toString() {
        String formatStr = "CartItem(%3d, book_id: %3d, %d)";
        return String.format(formatStr, id, book.getId(), quantity);
    }


}
