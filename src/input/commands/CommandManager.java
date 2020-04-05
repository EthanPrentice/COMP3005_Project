package input.commands;

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
                new ExitCommand()
        };

        for (Command command : commands) {
            commandMap.put(command.getCommandString(), command);
        }

        return commandMap;
    }

    public void runCommand(String commandName) throws IllegalArgumentException {
        Command command = commands.get(commandName);
        if (command != null) {
            command.run();
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
            commands.get(key).printHelp();
        }
    }

    public void printHelp(String commandName) {
        commands.get(commandName).printHelp();
    }
}
