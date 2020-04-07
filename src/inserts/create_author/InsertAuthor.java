package inserts.create_author;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertAuthor extends Insert {

    public InsertAuthor(Connection conn) throws SQLException {
        super(conn, "create_author/insert_author.sql");
    }

}
