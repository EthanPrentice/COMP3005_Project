package queries.user;

import adt.sql.BuildableQuery;
import adt.sql.OrderBy;
import adt.sql_tables.Book;
import adt.sql_tables.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetUserFromCreds extends BuildableQuery<User> {

    public GetUserFromCreds(Connection conn, String username, String password) throws SQLException {
        super(conn, "user/get_user_from_creds.sql");
        build(username, password);
    }

    @Override
    public User get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new User(rs);
        }

        return null;
    }


}
