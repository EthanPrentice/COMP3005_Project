package input.commands;

import java.sql.SQLException;

public abstract class Command {

    private String commandString;

    protected Command(String commandString) {
        this.commandString = commandString;
    }

    public void printHelp() {
        String formatStr = "%-15s\t%s\n";
        System.out.printf(formatStr, commandString, getDescription());
    }

    public abstract void run(String[] args);
    protected abstract String getDescription();

    public String getCommandString() {
        return commandString;
    }
}
