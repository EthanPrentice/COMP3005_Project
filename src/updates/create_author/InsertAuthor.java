package updates.create_author;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertAuthor extends Update {

    public InsertAuthor(Connection conn) throws SQLException {
        super(conn, "create_author/insert_author.sql");
    }

}
