package input.commands.admin;

import input.commands.Command;
import input.commands.CommandCategory;

public abstract class AdminCommand extends Command {

    public AdminCommand(String commandString, CommandCategory category) {
        super(commandString, category);
    }

    @Override
    public abstract void run(String[] args);
}
