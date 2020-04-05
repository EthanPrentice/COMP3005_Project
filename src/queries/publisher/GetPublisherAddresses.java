package queries.publisher;

import adt.sql.BuildableQuery;
import adt.sql_tables.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetPublisherAddresses extends BuildableQuery<ArrayList<Address>> {

    public GetPublisherAddresses(Connection conn, Integer publisherId) throws SQLException {
        super(conn, "publisher/get_publisher_addresses.sql");
        build(publisherId);
    }


    @Override
    public ArrayList<Address> get() throws SQLException {
        ResultSet rs = execute();

        ArrayList<Address> addresses = new ArrayList<>();

        while (rs.next()) {
            addresses.add(new Address(rs));
        }

        return addresses;
    }
}
