package inserts.add_cart_item;

import adt.sql.MultiUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCartItem implements MultiUpdate {

    private Connection conn;

    private int cartId;
    private int bookId;
    private int quantity;

    private Integer cartItemId = null;

    public AddCartItem(Connection conn, int cartId, int bookId, int quantity) {
        this.conn = conn;
        this.cartId = cartId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    private int insertCartItem() throws SQLException{
        InsertCartItem insertCartItem = new InsertCartItem(conn, quantity);
        insertCartItem.executeUpdate(false);

        ResultSet rs = insertCartItem.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert CartItem.  Rolling back.");
        }
    }

    @Override
    public void executeUpdates() throws SQLException {
        executeUpdates(true);
    }

    @Override
    public void executeUpdates(boolean commit) throws SQLException {
        int cartItemId = insertCartItem();

        InsertBookInItem insertBookInItem = new InsertBookInItem(conn, cartItemId, bookId);
        insertBookInItem.executeUpdate(false);

        InsertItemInCart insertItemInCart = new InsertItemInCart(conn, cartItemId, cartId);
        insertItemInCart.executeUpdate(false);

        this.cartItemId = cartItemId;
        if (commit) {
            conn.commit();
        }
    }

    public Integer getCartItemId() {
        return cartItemId;
    }
}
