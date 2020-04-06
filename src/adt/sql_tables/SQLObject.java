package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class SQLObject {

    protected Integer id;

    public SQLObject(ResultSet rs) throws SQLException {
        id = null;
    }

    public SQLObject() {
        id = null;
    }

    public Integer getId() {
        return id;
    }

}
