package inserts.create_publisher;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertPublisher extends Update {

    public InsertPublisher(Connection conn, String name) throws SQLException {
        super(conn, "create_publisher/insert_publisher.sql");
        setParams(name);
    }

}
