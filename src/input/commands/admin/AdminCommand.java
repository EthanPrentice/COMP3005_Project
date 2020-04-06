package input.commands.admin;

import input.commands.Command;

public abstract class AdminCommand extends Command {

    public AdminCommand(String commandString) {
        super(commandString);
    }

    @Override
    public abstract void run(String[] args);
}
