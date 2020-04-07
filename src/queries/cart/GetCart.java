package queries.cart;

import adt.sql.BuildableQuery;
import adt.sql_tables.Cart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCart extends BuildableQuery<Cart> {

    public GetCart(Connection conn, int userId) throws SQLException {
        super(conn, "cart/get_cart.sql");
        build(userId);
    }

    @Override
    public Cart get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new Cart(rs);
        }
        return null;
    }
}
