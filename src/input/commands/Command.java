package input.commands;

import input.InfoManager;
import input.commands.admin.AdminCommand;

public abstract class Command {

    private String commandString;
    private CommandCategory category;

    protected Command(String commandString, CommandCategory category) {
        this.commandString = commandString;
        this.category = category;
    }

    public void printHelp() {
        String formatStr = "%-25s\t%s\n";
        if (this instanceof AdminCommand && InfoManager.isUserAdmin()) {
            System.out.printf(formatStr, commandString, "*" + getDescription() + "*");
        }
        else if (!(this instanceof AdminCommand)) {
            System.out.printf(formatStr, commandString, getDescription());
        }
    }

    public abstract void run(String[] args);
    protected abstract String getDescription();

    public String getCommandString() {
        return commandString;
    }

    public CommandCategory getCategory() {
        return category;
    }
}
