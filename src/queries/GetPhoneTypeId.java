package queries;

import adt.sql.BuildableQuery;
import adt.sql_tables.SoldItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetPhoneTypeId extends BuildableQuery {

    public GetPhoneTypeId(Connection conn, String phoneType) throws SQLException {
        super(conn, "get_phone_type_id.sql");
        build(phoneType);
    }


    public Integer getPhoneTypeId() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            return null;
        }
    }


}
