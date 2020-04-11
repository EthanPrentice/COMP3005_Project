package queries.user;

import adt.sql.BuildableQuery;
import adt.sql_tables.BillingInfo;
import adt.sql_tables.ShippingInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUserShippingInfo extends BuildableQuery<ShippingInfo> {

    public GetUserShippingInfo(Connection conn, int userId) throws SQLException {
        super(conn, "user/get_user_shipping_info.sql");
        build(userId);
    }

    @Override
    public ShippingInfo get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new ShippingInfo(rs);
        }

        return null;
    }
}
