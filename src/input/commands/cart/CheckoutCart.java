package input.commands.cart;

import adt.sql_tables.*;
import input.InfoManager;
import input.commands.Command;
import input.commands.CommandCategory;
import inserts.create_order_from_cart.CreateOrderFromCart;
import javafx.util.Pair;
import queries.cart.GetCartItems;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckoutCart extends Command {

    private Connection conn;

    public CheckoutCart(Connection conn) {
        super("/checkout", CommandCategory.CART);
        this.conn = conn;
    }

    private boolean validateCart(Cart cart) throws SQLException {
        GetCartItems getCartItems = new GetCartItems(conn, cart.getId());
        ArrayList<CartItem> cartItems = getCartItems.get();

        boolean valid = true;

        for (CartItem item : cartItems) {
            Book book = item.getBook(conn);
            int bookQuantity = book.getQuantity(conn);
            if (item.getQuantity() > bookQuantity) {
                valid = false;
                System.out.printf("There are only %d of %s in stock.  Please reduce quantity to continue.\n", bookQuantity, book.getTitle());
            }
        }

        return valid;
    }


    private Pair<PersonName, Address> getShippingInfo() throws SQLException {
        User currUser = InfoManager.getCurrentUser();
        ShippingInfo userShippingInfo = currUser.getShippingInfo(conn);

        if (userShippingInfo != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Current Shipping Info:\n%s\n", userShippingInfo.toString(conn));
            System.out.println("Would you like to use different info? (y/n): ");

            String answer = scanner.nextLine().trim();
            while (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("Invalid choice.");

                System.out.println("Would you like to use different info? (y/n): ");
                answer = scanner.nextLine();
            }

            if (answer.equals("n")) {
                return new Pair<>(userShippingInfo.getName(conn), userShippingInfo.getAddress(conn));
            }
        }

        System.out.println("Enter order shipping information: ");
        System.out.println("Name: ");
        PersonName name = PersonName.createFromUserInputs();
        System.out.println("\nAddress: ");
        Address address = Address.createFromUserInputs();

        return new Pair<>(name, address);
    }


    private Pair<PersonName, Address> getBillingInfo() throws SQLException {
        User currUser = InfoManager.getCurrentUser();
        BillingInfo userBillingInfo = currUser.getBillingInfo(conn);

        if (userBillingInfo != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Current Billing Info:\n%s\n", userBillingInfo.toString(conn));
            System.out.println("Would you like to use different info? (y/n): ");

            String answer = scanner.nextLine().trim();
            while (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("Invalid choice.");

                System.out.println("Would you like to use different info? (y/n): ");
                answer = scanner.nextLine();
            }

            if (answer.equals("n")) {
                return new Pair<>(userBillingInfo.getName(conn), userBillingInfo.getAddress(conn));
            }
        }

        System.out.println("Enter order billing information: ");
        System.out.println("Name: ");
        PersonName name = PersonName.createFromUserInputs();
        System.out.println("\nAddress: ");
        Address address = Address.createFromUserInputs();

        return new Pair<>(name, address);
    }


    @Override
    public void run(String[] args) {
        try {
            User currUser = InfoManager.getCurrentUser();
            Cart userCart = currUser.getCart(conn);

            System.out.println(userCart.toString(conn));

            if (validateCart(userCart)) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Continue with checkout? (y/n): ");
                if (!scanner.nextLine().trim().equals("y")) {
                    System.out.println("Cancelling checkout.");
                    return;
                }
                System.out.print("\n");


                Pair<PersonName, Address> shippingInfo = getShippingInfo();
                Pair<PersonName, Address> billingInfo;

                System.out.print("Use shipping info and billing info? (y/n): ");
                if (scanner.nextLine().trim().equals("y")) {
                    billingInfo = shippingInfo;
                }
                else {
                    billingInfo = getBillingInfo();
                }
                System.out.print("\n");

                PersonName shippingName = shippingInfo.getKey();
                Address shippingAddr = shippingInfo.getValue();

                PersonName billingName = billingInfo.getKey();
                Address billingAddr = billingInfo.getValue();

                CreateOrderFromCart createOrder = new CreateOrderFromCart(conn, userCart.getId(), billingAddr, billingName, shippingAddr, shippingName);
                createOrder.executeUpdates(true);
                System.out.println("A new order has been created!\n");
            }
        }
        catch (SQLException e) {
            System.out.println("The system was unable to checkout the user!\n");
        }
    }

    @Override
    protected String getDescription() {
        return "Orders items in the current user's cart.";
    }
}
