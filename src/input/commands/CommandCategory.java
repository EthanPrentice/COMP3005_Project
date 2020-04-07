package input.commands;

public enum CommandCategory {

    ADMIN("Admin"),
    USER("User"),
    GENERAL("General"),
    OTHER("Other");


    private String value;
    private CommandCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
