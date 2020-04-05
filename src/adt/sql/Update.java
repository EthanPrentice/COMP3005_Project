package adt.sql;

import utils.config.Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;


public class Update {

    protected Connection conn = null;
    protected PreparedStatement stmt = null;

    public Update(Connection conn, String sqlFilename) throws SQLException {
        this.conn = conn;

        Path filePath = Paths.get(Config.getUpdatesPath().toString(), sqlFilename);

        try {
            FileReader fr = new FileReader(filePath.toString());
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }

            br.close();
            fr.close();

            // Return generated keys for update, needed for chaining statements that depend on auto-incremented IDs
            stmt = conn.prepareStatement(sb.toString(), Statement.RETURN_GENERATED_KEYS);

        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

    public void setParams(Object... objects) throws SQLException {
        int i=1;
        for (Object obj : objects) {
            if (obj == null) {
                stmt.setNull(i++, java.sql.Types.NULL);
            }
            else {
                stmt.setObject(i++, obj);
            }
        }
    }

    public int executeUpdate() throws SQLException {
        return executeUpdate(true);
    }

    public int executeUpdate(boolean commit) throws SQLException {
        int res = stmt.executeUpdate();
        if (commit) {
            stmt.getConnection().commit();
        }
        return res;
    }

    public ResultSet getGeneratedKeys() throws SQLException {
        return stmt.getGeneratedKeys();
    }

}
