package input.commands;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("/exit", CommandCategory.OTHER);
    }

    @Override
    public void run(String[] args) {
        System.exit(0);
    }

    @Override
    protected String getDescription() {
        return "Exits the application";
    }
}
