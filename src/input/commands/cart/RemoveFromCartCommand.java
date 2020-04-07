package input.commands.cart;

import adt.sql_tables.Book;
import adt.sql_tables.Cart;
import adt.sql_tables.CartItem;
import adt.sql_tables.User;
import deletions.DeleteCartItem;
import input.InfoManager;
import input.commands.Command;
import input.commands.CommandCategory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveFromCartCommand extends Command {

    private Connection conn;

    public RemoveFromCartCommand(Connection conn) {
        super("/remove-from-cart", CommandCategory.CART);
        this.conn = conn;
    }

    @Override
    public void run(String[] args) {
        if (!InfoManager.isLoggedIn()) {
            System.out.println("Only logged in users can have carts.  Use /sign-up or /login");
            return;
        }

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Cart Item ID: ");
            int cartItemIndex = Integer.parseInt(scanner.nextLine()) - 1;

            User user = InfoManager.getCurrentUser();
            Cart userCart = user.getCart(conn);

            Book deletedBook = userCart.getItems(conn).get(cartItemIndex).getBook(conn);
            userCart.removeItem(conn, cartItemIndex);

            System.out.printf("Deleted %s from the cart.\n", deletedBook.getTitle());
        }
        catch (NumberFormatException e) {
            System.out.println("Error: input was not a valid integer!");
        }
        catch (SQLException e) {
            System.out.println("Was unable to remove the item from the cart.");
        }
    }

    @Override
    protected String getDescription() {
        return "Removes a book from the cart";
    }
}
