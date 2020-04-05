package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Author extends SQLObject {

    private PersonName name;

    public Author(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("author_id");

        name = new PersonName(rs);
    }

    public PersonName getName() {
        return name;
    }
}
