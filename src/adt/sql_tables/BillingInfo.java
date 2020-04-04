package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillingInfo extends SQLObject {

    private PersonName name;
    private Address address;

    BillingInfo(ResultSet rs) throws SQLException {
        id = rs.getInt("billing_info_id");
    }

    BillingInfo(PersonName name, Address address) {
        this.name = name;
        this.address = address;
    }

    public PersonName getName() {
        // TODO: implement query for this if id is null
        if (id == null) {

        }
        else {
            return name;
        }
        return null;
    }

    public Address getAddress() {
        // TODO: implement query for this if id is null
        if (id == null) {

        }
        else {
            return null;
        }
        return null;
    }
}
