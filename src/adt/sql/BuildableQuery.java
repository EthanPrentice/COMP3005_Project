package adt.sql;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BuildableQuery<T> extends Query<T> {

    public BuildableQuery(Connection conn, String queryFilename) throws SQLException {
        super(conn, queryFilename);
    }

    public void build(Object... objects) throws SQLException {
        int i=1;
        for (Object obj : objects) {
            stmt.setObject(i++, obj);
        }
    }
}
