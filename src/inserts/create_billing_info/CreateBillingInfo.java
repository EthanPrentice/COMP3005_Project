package inserts.create_billing_info;

import adt.sql.MultiUpdate;
import adt.sql_tables.Address;
import adt.sql_tables.PersonName;
import inserts.InsertAddress;
import inserts.InsertName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateBillingInfo implements MultiUpdate {

    private Connection conn;

    private PersonName name;
    private Address address;

    private Integer billingInfoId = null;

    public CreateBillingInfo(Connection conn, PersonName name, Address address) {
        this.conn = conn;
        this.name = name;
        this.address = address;
    }

    private int insertName() throws SQLException {
        InsertName insertName = new InsertName(conn, name);
        insertName.executeUpdate(false);

        ResultSet rs = insertName.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert a new name.  Rolling back.");
        }
    }

    private int insertAddress() throws SQLException {
        InsertAddress insertAddress = new InsertAddress(conn, address);
        insertAddress.executeUpdate(false);

        ResultSet rs = insertAddress.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert a new address.  Rolling back.");
        }
    }

    private int insertBillingInfo() throws SQLException {
        InsertBillingInfo insertBillingInfo = new InsertBillingInfo(conn);
        insertBillingInfo.executeUpdate(false);

        ResultSet rs = insertBillingInfo.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert new billing info.  Rolling back.");
        }
    }

    public Integer getBillingInfoId() {
        return billingInfoId;
    }

    @Override
    public void executeUpdates() throws SQLException {
        executeUpdates(true);
    }

    @Override
    public void executeUpdates(boolean commit) throws SQLException {
        int nameId = insertName();
        int addressId = insertAddress();
        int billingInfoId = insertBillingInfo();

        InsertBillingName insertBillingName = new InsertBillingName(conn, billingInfoId, nameId);
        InsertBillingAddress insertBillingAddress = new InsertBillingAddress(conn, billingInfoId, addressId);

        insertBillingName.executeUpdate(false);
        insertBillingAddress.executeUpdate(false);

        this.billingInfoId = billingInfoId;

        if (commit) {
            conn.commit();
        }
    }
}
