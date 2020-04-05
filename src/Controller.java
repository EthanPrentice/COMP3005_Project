import adt.sql.OrderBy;
import adt.sql.Ordering;
import adt.sql_tables.*;
import inserts.create_user.CreateUser;
import queries.GetItemsInCart;
import utils.config.Config;

import java.sql.*;
import java.util.ArrayList;
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

            OrderBy orderBy = new OrderBy();
            orderBy.add("price", Ordering.DESC);

            GetItemsInCart query = new GetItemsInCart(conn, 1);

            ArrayList<CartItem> results = query.get();
            for (SQLObject res : results) {
                System.out.println(res);
            }

//            CreateOrderFromCart update = new CreateOrderFromCart(conn, 1);
//            update.executeUpdates();

            CreateUser createUser = new CreateUser(
                    conn,
                    "user123",
                    "user123@yahoo.ca",
                    "pass123",
                    null,
                    null,
                    null
            );

            createUser.executeUpdates(true);

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
