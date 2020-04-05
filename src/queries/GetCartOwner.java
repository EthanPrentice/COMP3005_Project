package queries;

import adt.sql.BuildableQuery;
import adt.sql_tables.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCartOwner extends BuildableQuery {

    public GetCartOwner(Connection conn, Integer cartId) throws SQLException {
        super(conn, "get_cart_owner.sql");
        build(cartId);
    }


    public User getOwner() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new User(rs);
        }
        else {
            return null;
        }
    }

}
