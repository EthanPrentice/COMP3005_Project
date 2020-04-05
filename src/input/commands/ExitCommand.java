package input.commands;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("/exit");
    }

    @Override
    public void run() {
        System.exit(0);
    }

    @Override
    protected String getDescription() {
        return "Exits the application";
    }
}
