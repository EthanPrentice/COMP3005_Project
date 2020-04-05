package adt.sql;

import java.sql.SQLException;

public interface MultiUpdate {

    public void executeUpdates() throws SQLException;
    public void executeUpdates(boolean commit) throws SQLException;

}
