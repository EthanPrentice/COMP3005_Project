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
    private HashMap<CommandCategory, ArrayList<String>> helpOrdering;

    public CommandManager(Connection conn) {
        Command[] commands = {
                new ShowPrevMonthSales(conn),

                new LoginCommand(conn),
                new LogOutCommand(),
                new GetCurrentUser(),

                new SearchBooksCommand(conn),

                new ExitCommand()
        };

        buildCommandMap(commands);
        buildHelpMap(commands);
    }

    private void buildCommandMap(Command[] commands) {
        commandMap = new HashMap<>();

        for (Command command : commands) {
            commandMap.put(command.getCommandString(), command);
        }
    }

    private void buildHelpMap(Command[] commands) {
        helpOrdering = new HashMap<>();

        for (Command command : commands) {
            ArrayList<String> categoryCommands = helpOrdering.getOrDefault(command.getCategory(), new ArrayList<>());
            categoryCommands.add(command.getCommandString());

            if (!helpOrdering.containsKey(command.getCategory())) {
                helpOrdering.put(command.getCategory(), categoryCommands);
            }
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

    private void printHelp() {
        for (CommandCategory category : helpOrdering.keySet()) {
            if (!InfoManager.isUserAdmin() && category == CommandCategory.ADMIN) {
                continue;
            }

            System.out.println(category.getValue());

            for (String commandName : helpOrdering.get(category)) {
                printHelp(commandName);
            }
            System.out.println("");
        }
    }

    private void printHelp(String commandName) {
        commandMap.get(commandName).printHelp();
    }
}
