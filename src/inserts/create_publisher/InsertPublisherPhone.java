package inserts.create_publisher;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertPublisherPhone extends Update {

    public InsertPublisherPhone(Connection conn, int phoneId, int publisherId) throws SQLException {
        super(conn, "create_publisher/insert_publisher_phone.sql");
        setParams(phoneId, publisherId);
    }
}
