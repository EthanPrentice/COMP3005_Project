package inserts.create_shipping_info;

import adt.sql.MultiUpdate;
import adt.sql_tables.Address;
import adt.sql_tables.PersonName;
import inserts.InsertAddress;
import inserts.InsertName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateShippingInfo implements MultiUpdate {


    private Connection conn;

    private PersonName name;
    private Address address;

    private Integer shippingInfoId = null;

    public CreateShippingInfo(Connection conn, PersonName name, Address address) {
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

    private int insertShippingInfo() throws SQLException {
        InsertShippingInfo insertShippingInfo = new InsertShippingInfo(conn);

        ResultSet rs = insertShippingInfo.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert new shipping info.  Rolling back.");
        }
    }

    public Integer getShippingInfoId() {
        return shippingInfoId;
    }

    @Override
    public void executeUpdates() throws SQLException {
        executeUpdates(true);
    }

    @Override
    public void executeUpdates(boolean commit) throws SQLException {
        int nameId = insertName();
        int addressId = insertAddress();
        int shippingInfoId = insertShippingInfo();

        InsertShippingName insertShippingName = new InsertShippingName(conn, shippingInfoId, nameId);
        InsertShippingAddress insertShippingAddress = new InsertShippingAddress(conn, shippingInfoId, addressId);

        insertShippingName.executeUpdate(false);
        insertShippingAddress.executeUpdate(false);

        this.shippingInfoId = shippingInfoId;
        if (commit) {
            conn.commit();
        }
    }
    
}
