package updates.create_author;

import adt.sql.MultiUpdate;
import adt.sql_tables.PersonName;
import updates.InsertName;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateAuthor implements MultiUpdate {

    private Connection conn;
    private PersonName name;

    private Integer authorId = null;

    public CreateAuthor(Connection conn, PersonName name) {
        this.conn = conn;
        this.name = name;
    }


    private int insertAuthor() throws SQLException {
        InsertAuthor insertAuthor = new InsertAuthor(conn);
        insertAuthor.executeUpdate(false);

        ResultSet generatedKeys = insertAuthor.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert author.  Rolling back");
        }
    }

    private int insertName() throws SQLException {
        InsertName insertName = new InsertName(conn, name);
        insertName.executeUpdate(false);

        ResultSet generatedKeys = insertName.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not insert name.  Rolling back");
        }
    }


    @Override
    public void executeUpdates() throws SQLException {
        executeUpdates(true);
    }

    @Override
    public void executeUpdates(boolean commit) throws SQLException {
        int authorId = insertAuthor();
        int nameId = insertName();

        InsertAuthorName insertAuthorName = new InsertAuthorName(conn, authorId, nameId);
        insertAuthorName.executeUpdate(false);

        this.authorId = authorId;
        if (commit) {
            conn.commit();
        }
    }

    public Integer getAuthorId() {
        return authorId;
    }
}
