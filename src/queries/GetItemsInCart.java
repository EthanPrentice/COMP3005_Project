package queries;

import adt.sql.BuildableQuery;
import adt.sql.OrderBy;
import adt.sql_tables.CartItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetItemsInCart extends BuildableQuery<ArrayList<CartItem>> {

    public GetItemsInCart(Connection conn, Integer cartId) throws SQLException {
        super(conn, "get_items_in_cart.sql");
        build(cartId);
    }

    @Override
    public ArrayList<CartItem> get() throws SQLException {
        ResultSet rs = execute();

        ArrayList<CartItem> items = new ArrayList<>();
        while (rs.next()) {
            items.add(new CartItem(rs));
        }

        return items;
    }


}
