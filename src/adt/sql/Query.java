package adt.sql;

import utils.config.Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {

    protected Connection conn = null;
    protected PreparedStatement stmt = null;

    public Query(Connection conn, String queryFilename) throws SQLException {
        this.conn = conn;

        Path filePath = Paths.get(Config.getQueryPath().toString(), queryFilename);

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

            stmt = conn.prepareStatement(sb.toString());

        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

    protected void build(Object... objects) throws SQLException {
        int i=1;
        for (Object obj : objects) {
            stmt.setObject(i++, obj);
        }
    }

    public ResultSet execute() throws SQLException {
        return stmt.executeQuery();
    }

}
