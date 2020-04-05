package updates.create_phone_number;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertPhoneIsType extends Update {

    public InsertPhoneIsType(Connection conn, Integer phoneId, Integer phoneTypeId) throws SQLException {
        super(conn, "create_phone_number/insert_phone_is_type.sql");
        setParams(phoneId, phoneTypeId);
    }

}
