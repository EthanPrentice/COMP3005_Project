package adt.sql_tables;

import queries.publisher.GetPublisherAddresses;
import queries.publisher.GetPublisherBankAccount;
import queries.publisher.GetPublisherPhones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Publisher extends SQLObject {

    private String name;

    public Publisher(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("publisher_id");
        name = rs.getString("publisher_name");
    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount(Connection conn) throws SQLException {
        GetPublisherBankAccount getBankAcc = new GetPublisherBankAccount(conn, id);
        return getBankAcc.get();
    }

    public ArrayList<PhoneNumber> getPhoneNumbers(Connection conn) throws SQLException {
        GetPublisherPhones getPhone = new GetPublisherPhones(conn, id);
        return getPhone.get();
    }

    public ArrayList<Address> getAddresses(Connection conn) throws SQLException  {
        GetPublisherAddresses getAddress = new GetPublisherAddresses(conn, id);
        return getAddress.get();
    }

}
