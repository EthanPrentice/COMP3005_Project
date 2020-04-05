package input.commands;

import input.commands.book.SearchBooksCommand;
import input.commands.user.GetCurrentUser;
import input.commands.user.LoginCommand;
import input.commands.user.LogOutCommand;

import java.sql.Connection;
import java.util.HashMap;

public class CommandManager {

    private HashMap<String, Command> commands;

    public CommandManager(Connection conn) {
        commands = buildCommandMap(conn);
    }

    private HashMap<String, Command> buildCommandMap(Connection conn) {
        HashMap<String, Command> commandMap = new HashMap<>();

        Command[] commands = {
                new LoginCommand(conn),
                new LogOutCommand(),
                new GetCurrentUser(),

                new SearchBooksCommand(conn),

                new ExitCommand()
        };

        for (Command command : commands) {
            commandMap.put(command.getCommandString(), command);
        }

        return commandMap;
    }

    public void runCommand(String commandName) throws IllegalArgumentException {

        String[] args = commandName.split(" ");

        Command command = commands.get(args[0]);
        if (command != null) {
            command.run(args);
        }
        else if (commandName.equals("/help")) {
            printHelp();
        }
        else {
            throw new IllegalArgumentException("Could not find the command " + commandName);
        }
    }

    public void printHelp() {
        for (String key : commands.keySet()) {
            printHelp(key);
        }
    }

    public void printHelp(String commandName) {
        commands.get(commandName).printHelp();
    }
}
