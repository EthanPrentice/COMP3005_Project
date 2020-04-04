import utils.config.Config;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;

public class Controller {

    private Connection conn;

    public Controller() {
        setCredentials();
        System.out.print("\n");
        setDBName();
        try {
            System.out.printf("\nConnecting to %s\n\n", Config.getDBConfig().getUrl());
            conn = getConnection(Config.getDBConfig().getUrl());
        }
        catch (SQLException e) {
            System.err.println(e.toString());
            System.exit(-1);
        }
    }

    private void setDBName() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Database PersonName: ");
      String dbName = scanner.next();
      Config.getDBConfig().setDBName(dbName);
    }

    private void setCredentials() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();

        Config.getDBConfig().setCredentials(username, password);
    }

    private Connection getConnection(String url) throws SQLException {
        return DriverManager.getConnection(url, Config.getDBConfig().getUser(), Config.getDBConfig().getPassword());
    }

    public static void main(String[] args) {
        Controller ctrlr = new Controller();
    }
}
