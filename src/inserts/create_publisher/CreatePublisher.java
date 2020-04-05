package inserts.create_publisher;

import adt.sql.MultiUpdate;
import adt.sql_tables.Address;
import adt.sql_tables.BankAccount;
import adt.sql_tables.PhoneNumber;
import inserts.InsertAddress;
import inserts.create_phone_number.CreatePhoneNumber;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreatePublisher implements MultiUpdate {

    private Connection conn;

    private String publisherName;
    private BankAccount bankAccount;
    private ArrayList<PhoneNumber> phoneNumbers;
    private ArrayList<Address> addresses;

    private Integer publisherId = null;

    public CreatePublisher(Connection conn, String publisherName, BankAccount bankAccount, ArrayList<PhoneNumber> phoneNumbers, ArrayList<Address> addresses) throws IllegalStateException {
        this.conn = conn;
        this.publisherName = publisherName;
        this.bankAccount = bankAccount;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;

        if (addresses.isEmpty()) {
            throw new IllegalStateException("Cannot create a publisher without an address.");
        }
        if (phoneNumbers.isEmpty()) {
            throw new IllegalStateException("Cannot create a publisher without an phone number.");
        }
    }

    private int insertPublisher() throws SQLException {
        InsertPublisher insertPublisher = new InsertPublisher(conn, publisherName);
        insertPublisher.executeUpdate(false);

        ResultSet rs = insertPublisher.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert publisher.  Rolling back.");
        }
    }


    private int insertBankAccount() throws SQLException {
        InsertBankAccount insertBankAccount = new InsertBankAccount(conn, bankAccount);
        insertBankAccount.executeUpdate(false);

        ResultSet rs = insertBankAccount.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert bank account.  Rolling back.");
        }
    }

    private int createPhoneNumber(PhoneNumber phoneNumber) throws SQLException {
        CreatePhoneNumber createPhone = new CreatePhoneNumber(conn, phoneNumber);
        createPhone.executeUpdates(false);

        if (createPhone.getPhoneNumberId() != null) {
            return createPhone.getPhoneNumberId();
        }
        else {
            conn.rollback();
            throw new SQLException("Could not create phone number.  Rolling back.");
        }
    }

    private int insertAddress(Address address) throws SQLException {
        InsertAddress insertAddress = new InsertAddress(conn, address);
        insertAddress.executeUpdate(false);

        ResultSet rs = insertAddress.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert address.  Rolling back.");
        }
    }


    @Override
    public void executeUpdates() throws SQLException {
        executeUpdates(true);
    }

    @Override
    public void executeUpdates(boolean commit) throws SQLException {
        int publisherId = insertPublisher();
        int bankAccountId = insertBankAccount();

        InsertPublisherBankAccount insertPublisherBankAcc = new InsertPublisherBankAccount(conn, bankAccountId, publisherId);
        insertPublisherBankAcc.executeUpdate(false);

        int phoneId;
        InsertPublisherPhone insertPublisherPhone;
        for (PhoneNumber phone : phoneNumbers) {
            phoneId = createPhoneNumber(phone);
            insertPublisherPhone = new InsertPublisherPhone(conn, phoneId, publisherId);
            insertPublisherPhone.executeUpdate(false);
        }

        int addressId;
        InsertPublisherAddress insertPublisherAddress;
        for (Address address : addresses) {
            addressId = insertAddress(address);
            insertPublisherAddress = new InsertPublisherAddress(conn, addressId, publisherId);
            insertPublisherAddress.executeUpdate(false);
        }

        this.publisherId = publisherId;
        if (commit) {
            conn.commit();
        }
    }

    public Integer getPublisherId() {
        return publisherId;
    }
}
