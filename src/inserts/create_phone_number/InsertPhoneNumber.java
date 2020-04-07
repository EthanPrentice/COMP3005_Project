package inserts.create_phone_number;

import adt.sql.Insert;
import adt.sql_tables.PhoneNumber;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertPhoneNumber extends Insert {

    public InsertPhoneNumber(Connection conn, Integer region, String number) throws SQLException {
        super(conn, "create_phone_number/insert_phone_number.sql");
        number = number.replaceAll("[^0-9]", "");
        setParams(region, number);
    }

    public InsertPhoneNumber(Connection conn, PhoneNumber phoneNumber) throws SQLException {
        super(conn, "create_phone_number/insert_phone_number.sql");
        setParams(phoneNumber.getRegion(), phoneNumber.getNumber());
    }

}
