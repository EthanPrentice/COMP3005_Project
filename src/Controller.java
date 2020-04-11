import adt.InputParser;
import adt.sql.OrderBy;
import adt.sql.Ordering;
import adt.sql_tables.*;
import input.commands.Command;
import input.commands.CommandManager;
import inserts.create_publisher.CreatePublisher;
import inserts.create_user.CreateUser;
import queries.GetItemsInCart;
import queries.publisher.GetPublisher;
import utils.config.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
            conn.setAutoCommit(false);

            CommandManager commandManager = new CommandManager(conn);

            Scanner scanner = new Scanner(System.in);
            String commandString;
            while(true) {
                try {
                    commandString = scanner.nextLine();
                    commandManager.runCommand(commandString);
                }
                catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            }

        }
        catch (SQLException e) {
            System.err.println(e.toString());
            System.exit(-1);
        }
    }

    private void setDBName() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Database Name: ");
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
