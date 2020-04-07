package inserts.create_phone_number;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertPhoneIsType extends Insert {

    public InsertPhoneIsType(Connection conn, Integer phoneId, Integer phoneTypeId) throws SQLException {
        super(conn, "create_phone_number/insert_phone_is_type.sql");
        setParams(phoneId, phoneTypeId);
    }

}
