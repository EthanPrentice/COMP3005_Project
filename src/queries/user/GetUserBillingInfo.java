package queries.user;

import adt.sql.BuildableQuery;
import adt.sql_tables.BillingInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserBillingInfo extends BuildableQuery<BillingInfo> {

    public GetUserBillingInfo(Connection conn, int userId) throws SQLException {
        super(conn, "user/get_user_billing_info.sql");
        build(userId);
    }

    @Override
    public BillingInfo get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new BillingInfo(rs);
        }

        return null;
    }
}
