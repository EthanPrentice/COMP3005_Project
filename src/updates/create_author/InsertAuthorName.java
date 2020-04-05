package updates.create_author;

import adt.sql.Update;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertAuthorName extends Update {

    public InsertAuthorName(Connection conn, Integer authorId, Integer nameId) throws SQLException {
        super(conn, "create_author/insert_author_name.sql");
        setParams(authorId, nameId);
    }

}
