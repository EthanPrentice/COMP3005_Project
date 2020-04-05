package input.commands.user;

import input.InfoManager;
import input.commands.Command;

public class LogOutCommand extends Command {

    public LogOutCommand() {
        super("/log-out");
    }

    @Override
    public void run() {
        InfoManager.setCurrentUser(null);
    }

    @Override
    public String getDescription() {
        return "Logs out of the current user's account.";
    }
}
