import adt.sql.OrderBy;
import adt.sql.Ordering;
import adt.sql_tables.*;
import inserts.create_publisher.CreatePublisher;
import inserts.create_user.CreateUser;
import queries.GetItemsInCart;
import queries.publisher.GetPublisher;
import utils.config.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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

//            PhoneNumber phoneOne = new PhoneNumber(1, "2265556241", "CORPORATE");
//            PhoneNumber phoneTwo = new PhoneNumber(2, "3155556001", "CORPORATE");
//            ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>(Arrays.asList(phoneOne, phoneTwo));
//
//            Address address = new Address("N3B3N9", null, 223, "Brookmead Street", "Elmira", "ON", "Canada");
//            ArrayList<Address> addresses = new ArrayList<>(Arrays.asList(address));
//
//            BankAccount bankAccount = new BankAccount(1, 31, "514865002");
//
//            CreatePublisher createPublisher = new CreatePublisher(conn, "Elmira Publishing", bankAccount, phoneNumbers, addresses);
//
//            createPublisher.executeUpdates(true);


            GetPublisher getPublisher = new GetPublisher(conn, 8);
            Publisher publisher = getPublisher.get();

            System.out.println("Publisher: " + publisher.getName());

            BankAccount bankAcc = publisher.getBankAccount(conn);
            System.out.println("Bank account ID: " + bankAcc.getId());

            System.out.println("Address IDs:");
            for (Address addr : publisher.getAddresses(conn)) {
                System.out.println(addr.getId());
            }

            System.out.println("Phone IDs: ");
            for (PhoneNumber phone : publisher.getPhoneNumbers(conn)) {
                System.out.println(phone.getId());
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
