package adt.sql;

import utils.config.Config;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;

public class Deletion extends Update {

    public Deletion(Connection conn, String sqlFilename) throws SQLException {
        super(conn, Paths.get(Config.getDeletionsPath().toString(), sqlFilename));
    }

}
