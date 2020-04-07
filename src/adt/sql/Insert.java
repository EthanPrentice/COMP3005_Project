package adt.sql;

import utils.config.Config;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

public class Insert extends Update {

    public Insert(Connection conn, String sqlFilename) throws SQLException {
        super(conn, Paths.get(Config.getInsertsPath().toString(), sqlFilename));
    }

}
