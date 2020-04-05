package queries.publisher;

import adt.sql.BuildableQuery;
import adt.sql_tables.Publisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetPublisher extends BuildableQuery<Publisher> {

    public GetPublisher(Connection conn, Integer publisherId) throws SQLException {
        super(conn, "publisher/get_publisher.sql");
        build(publisherId);
    }


    @Override
    public Publisher get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new Publisher(rs);
        }
        else {
            return null;
        }
    }
}