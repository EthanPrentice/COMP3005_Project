package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneNumber extends SQLObject {

    private int region;
    private String number;
    private String type;


    public PhoneNumber(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("phone_id");
        region = rs.getInt("region");
        number = rs.getString("number");
        type = rs.getString("type");
    }

    public PhoneNumber(int region, String number, String type) {
        this.region = region;
        this.number = number;
        this.type = type;
    }

    public int getRegion() {
        return region;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getFormattedNumber() {
        String formatStr = "+%d (%s) %s-%s";
        return String.format(formatStr, region, number.substring(0, 4), number.substring(4, 8), number.substring(8));
    }

}
