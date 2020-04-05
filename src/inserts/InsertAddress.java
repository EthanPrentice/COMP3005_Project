package inserts;

import adt.sql.Update;
import adt.sql_tables.Address;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertAddress extends Update {

    public InsertAddress(Connection conn, Address address) throws SQLException {
        super(conn, "insert_address.sql");
        setParams(
                address.getPostalCode(),
                address.getUnit(),
                address.getStreetNum(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getCountry()
        );
    }

}
