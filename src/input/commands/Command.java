package input.commands;

import input.InfoManager;
import input.commands.admin.AdminCommand;

import java.sql.SQLException;

public abstract class Command {

    private String commandString;

    protected Command(String commandString) {
        this.commandString = commandString;
    }

    public void printHelp() {
        String formatStr = "%-25s\t%s\n";
        if (this instanceof AdminCommand && InfoManager.isUserAdmin()) {
            System.out.printf(formatStr, commandString, "*" + getDescription() + "*");
        }
        else {
            System.out.printf(formatStr, commandString, getDescription());
        }
    }

    public abstract void run(String[] args);
    protected abstract String getDescription();

    public String getCommandString() {
        return commandString;
    }
}
