package adt.sql_tables;

import queries.cart.GetCartItemBook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItem extends SQLObject {

    private int quantity;

    public CartItem(Book book, int quantity) {
        this.id = null;
        this.quantity = quantity;
    }

    public CartItem(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("cart_item_id");
        quantity = rs.getInt("quantity");
    }

    public Book getBook(Connection conn) throws SQLException {
        GetCartItemBook getBook = new GetCartItemBook(conn, id);
        return getBook.get();
    }

    public int getQuantity() {
        return quantity;
    }

    public float getSubtotal(Connection conn) throws SQLException {
        return getBook(conn).getPrice() * quantity;
    }

}
