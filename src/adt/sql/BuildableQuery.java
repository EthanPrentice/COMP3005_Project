package adt.sql;

import java.sql.Connection;
import java.sql.SQLException;

public class BuildableQuery extends Query {

    public BuildableQuery(Connection conn, String queryFilename) throws SQLException {
        super(conn, queryFilename);
    }

    @Override
    public void build(Object... objects) throws SQLException {
        int i=1;
        for (Object obj : objects) {
            stmt.setObject(i++, obj);
        }
    }
}
