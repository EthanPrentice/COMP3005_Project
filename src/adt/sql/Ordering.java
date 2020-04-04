package adt.sql;

public enum Ordering {
    ASC("ASC"),
    DESC("DESC");

    private String value;
    private Ordering(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
