package input.commands.user;

import adt.sql_tables.User;
import input.InfoManager;
import input.commands.Command;
import queries.user.GetUserFromCreds;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginCommand extends Command {

    private Connection conn;

    public LoginCommand(Connection conn) {
        super("/login");
        this.conn = conn;
    }

    @Override
    public void run(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.next();

        System.out.print("Password: ");
        String password = scanner.next();

        try {
            GetUserFromCreds getUserFromCreds = new GetUserFromCreds(conn, username, password);
            User user = getUserFromCreds.get();

            if (user == null) {
                System.out.println("Invalid Credentials!!");
            } else {
                System.out.println("Logged in as " + user.getUsername());
                InfoManager.setCurrentUser(user);
            }
        }
        catch(SQLException e) {
            System.err.println("There was an error logging in");
        }
    }

    @Override
    protected String getDescription() {
        return "Prompts the user for login credentials and attempts to log in.";
    }
}
