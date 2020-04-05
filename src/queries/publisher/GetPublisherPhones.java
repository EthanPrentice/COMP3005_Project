package queries.publisher;

import adt.sql.BuildableQuery;
import adt.sql_tables.PhoneNumber;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetPublisherPhones extends BuildableQuery<ArrayList<PhoneNumber>> {

    public GetPublisherPhones(Connection conn, Integer publisherId) throws SQLException {
        super(conn, "publisher/get_publisher_phones.sql");
        build(publisherId);
    }


    @Override
    public ArrayList<PhoneNumber> get() throws SQLException {
        ResultSet rs = execute();

        ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();

        while (rs.next()) {
            phoneNumbers.add(new PhoneNumber(rs));
        }

        return phoneNumbers;
    }
}
