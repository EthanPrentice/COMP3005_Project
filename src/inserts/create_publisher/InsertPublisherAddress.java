package inserts.create_publisher;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertPublisherAddress extends Update {

    public InsertPublisherAddress(Connection conn, int addressId, int publisherId) throws SQLException {
        super(conn, "create_publisher/insert_publisher_address.sql");
        setParams(addressId, publisherId);
    }

}
