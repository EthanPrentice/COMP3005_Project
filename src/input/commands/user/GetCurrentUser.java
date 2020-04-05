package input.commands.user;

import adt.sql_tables.User;
import input.InfoManager;
import input.commands.Command;

public class GetCurrentUser extends Command {

    public GetCurrentUser() {
        super("/current-user");
    }

    @Override
    public void run() {
        User user = InfoManager.getCurrentUser();
        if (user == null) {
            System.out.println("There is no user logged in.");
        }
        else {
            System.out.println(user.getUsername() + " is currently logged in.");
        }
    }

    @Override
    public String getDescription() {
        return "Prints the username of the signed in user.";
    }
}
