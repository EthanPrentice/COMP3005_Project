package inserts.create_author;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertAuthorName extends Insert {

    public InsertAuthorName(Connection conn, Integer authorId, Integer nameId) throws SQLException {
        super(conn, "create_author/insert_author_name.sql");
        setParams(authorId, nameId);
    }

}
