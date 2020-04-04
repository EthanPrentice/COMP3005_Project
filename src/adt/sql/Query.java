package adt.sql;

import javafx.util.Pair;
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
import java.util.StringJoiner;

public class Query {

    protected Connection conn = null;
    protected PreparedStatement stmt = null;

    public Query(Connection conn, String queryFilename) throws SQLException {
        this(conn, queryFilename, new OrderBy());
    }


    public Query(Connection conn, String queryFilename, OrderBy orderBy) throws SQLException {
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

            if (!orderBy.getPairs().isEmpty()) {
                sb.append("\nORDER BY ");

                StringJoiner sj = new StringJoiner(", ");
                for (Pair<String, Ordering> pair : orderBy.getPairs()) {
                    sj.add(String.format("%s %s", pair.getKey(), pair.getValue()));
                }

                sb.append(sj.toString());
            }

            stmt = conn.prepareStatement(sb.toString());

        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }


    public ResultSet execute() throws SQLException {
        return stmt.executeQuery();
    }

}
