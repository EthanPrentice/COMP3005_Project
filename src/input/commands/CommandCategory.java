package input.commands;

public enum CommandCategory {

    ADMIN("Admin"),
    USER("User"),
    GENERAL("General"),
    CART("Cart"),
    OTHER("Other");


    private String value;
    private CommandCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
