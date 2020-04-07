package queries.cart;

import adt.sql.BuildableQuery;
import adt.sql_tables.CartItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetCartItems extends BuildableQuery<ArrayList<CartItem>> {

    public GetCartItems(Connection conn, int cartId) throws SQLException {
        super(conn, "cart/get_cart_items.sql");
        build(cartId);
    }

    @Override
    public ArrayList<CartItem> get() throws SQLException {
        ResultSet rs = execute();

        ArrayList<CartItem> cartItems = new ArrayList<>();
        while (rs.next()) {
            cartItems.add(new CartItem(rs));
        }

        return cartItems;
    }
}
