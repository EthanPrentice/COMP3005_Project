package inserts.create_phone_number;

import adt.sql.MultiUpdate;
import adt.sql_tables.PhoneNumber;
import queries.GetPhoneTypeId;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreatePhoneNumber implements MultiUpdate {

    private Connection conn;
    private PhoneNumber phoneNumber;

    private Integer phoneNumberId = null;

    public CreatePhoneNumber(Connection conn, PhoneNumber phoneNumber) {
        this.conn = conn;
        this.phoneNumber = phoneNumber;
    }

    private int insertPhoneNumber() throws SQLException {
        InsertPhoneNumber insertPhoneNumber = new InsertPhoneNumber(conn, phoneNumber);
        insertPhoneNumber.executeUpdate(false);

        ResultSet rs = insertPhoneNumber.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert phone number.  Rolling back.");
        }
    }

    @Override
    public void executeUpdates() throws SQLException {
        executeUpdates(true);
    }

    @Override
    public void executeUpdates(boolean commit) throws SQLException {
        int phoneNumberId = insertPhoneNumber();

        GetPhoneTypeId getPhoneTypeId = new GetPhoneTypeId(conn, phoneNumber.getType());
        Integer phoneTypeId = getPhoneTypeId.getPhoneTypeId();
        if (phoneTypeId == null) {
            getPhoneTypeId = new GetPhoneTypeId(conn, "OTHER");
            phoneTypeId = getPhoneTypeId.getPhoneTypeId();
        }

        InsertPhoneIsType insertPhoneIsType = new InsertPhoneIsType(conn, phoneNumberId, phoneTypeId);
        insertPhoneIsType.executeUpdate(false);

        this.phoneNumberId = phoneNumberId;
        if (commit) {
            conn.commit();
        }
    }

    public Integer getPhoneNumberId() {
        return phoneNumberId;
    }
}
