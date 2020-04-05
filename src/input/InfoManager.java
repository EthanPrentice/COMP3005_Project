package input;

import adt.sql_tables.User;

public class InfoManager {

    private static User currentUser = null;


    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        InfoManager.currentUser = currentUser;
    }
}
