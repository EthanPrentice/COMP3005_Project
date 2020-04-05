package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringJoiner;

public class PersonName extends SQLObject {

    private String first;
    private String middle;
    private String last;
    private String prefix;


    public PersonName(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("name_id");
        first = rs.getString("first");
        middle = rs.getString("middle");
        last = rs.getString("last");
        prefix = rs.getString("prefix");
    }

    public PersonName(String first, String middle, String last, String prefix) {
        this.id = null;
        this.first = first;
        this.middle = middle;
        this.last = last;
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

    public String getShort() {
        return first + " " + last;
    }

    public String getFull() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add(prefix).add(first).add(middle).add(last);

        return sj.toString();
    }

    @Override
    public String toString() {
        String formatStr = "PersonName(%3d, %s, %s, %s, %s)";
        return String.format(formatStr, id, prefix, first, middle, last);
    }

}
