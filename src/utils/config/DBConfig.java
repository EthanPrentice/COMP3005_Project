package utils.config;

public class DBConfig {
    // package private
    DBConfig() { }

    private final static String url = "jdbc:mysql://localhost:3306/";
    private final static String args = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String dbName = "";
    private static String user = null;
    private static String password = null;

    public String getUrl() {
        return url + dbName + args;
    }

    public void setDBName(String name) {
      dbName = name;
    }

    public void setCredentials(String user, String password) {
        DBConfig.user = user;
        DBConfig.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
