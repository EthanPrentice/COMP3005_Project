package input.commands.user;

import adt.sql_tables.User;
import input.InfoManager;
import input.commands.Command;
import input.commands.CommandCategory;

public class GetCurrentUser extends Command {

    public GetCurrentUser() {
        super("/current-user", CommandCategory.USER);
    }

    @Override
    public void run(String[] args) {
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
