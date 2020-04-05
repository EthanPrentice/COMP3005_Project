package inserts;

import adt.sql.Update;
import adt.sql_tables.PersonName;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertName extends Update {

    public InsertName(Connection conn, String first, String middle, String last, String prefix) throws SQLException {
        super(conn, "insert_name.sql");
        setParams(first, middle, last, prefix);
    }

    public InsertName(Connection conn, PersonName name) throws SQLException {
        super(conn, "insert_name.sql");
        setParams(name.getFirst(), name.getMiddle(), name.getLast(), name.getPrefix());
    }

}
