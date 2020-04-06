package input.commands;

import input.InfoManager;
import input.commands.admin.AdminCommand;
import input.commands.admin.ShowPrevMonthSales;
import input.commands.book.SearchBooksCommand;
import input.commands.user.GetCurrentUser;
import input.commands.user.LoginCommand;
import input.commands.user.LogOutCommand;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class CommandManager {

    private HashMap<String, Command> commandMap;
    ArrayList<String> helpOrdering;

    public CommandManager(Connection conn) {
        commandMap = new HashMap<>();
        helpOrdering = new ArrayList<>();

        Command[] commands = {
                new ShowPrevMonthSales(conn),

                new LoginCommand(conn),
                new LogOutCommand(),
                new GetCurrentUser(),

                new SearchBooksCommand(conn),

                new ExitCommand()
        };

        for (Command command : commands) {
            commandMap.put(command.getCommandString(), command);
            helpOrdering.add(command.getCommandString());
        }
    }

    public void runCommand(String commandName) throws IllegalArgumentException {
        String[] args = commandName.split(" ");

        Command command = commandMap.get(args[0]);
        if (command != null) {
            if (command instanceof AdminCommand) {
                if (InfoManager.isUserAdmin()) {
                    command.run(args);
                }
                else {
                    throw new IllegalArgumentException("You do not have permission for that command");
                }
            }
            else {
                command.run(args);
            }
        }
        else if (commandName.equals("/help")) {
            printHelp();
        }
        else {
            throw new IllegalArgumentException("Could not find the command " + commandName);
        }
    }

    public void printHelp() {
        for (String commandName : helpOrdering) {
            printHelp(commandName);
        }
    }

    public void printHelp(String commandName) {
        commandMap.get(commandName).printHelp();
    }
}
