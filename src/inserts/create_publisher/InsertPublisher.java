package inserts.create_publisher;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertPublisher extends Insert {

    public InsertPublisher(Connection conn, String name) throws SQLException {
        super(conn, "create_publisher/insert_publisher.sql");
        setParams(name);
    }

}
