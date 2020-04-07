package input.commands.user;

import input.InfoManager;
import input.commands.Command;
import input.commands.CommandCategory;

public class LogOutCommand extends Command {

    public LogOutCommand() {
        super("/log-out", CommandCategory.USER);
    }

    @Override
    public void run(String[] args) {
        InfoManager.setCurrentUser(null);
        System.out.println("User was logged out.");
    }

    @Override
    public String getDescription() {
        return "Logs out of the current user's account.";
    }
}
