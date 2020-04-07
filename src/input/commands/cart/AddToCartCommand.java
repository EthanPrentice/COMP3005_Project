package input.commands.cart;

import adt.sql_tables.Book;
import adt.sql_tables.Cart;
import input.InfoManager;
import input.commands.Command;
import input.commands.CommandCategory;
import queries.book.GetBookById;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class AddToCartCommand extends Command {

    private Connection conn;

    public AddToCartCommand(Connection conn) {
        super("/add-to-cart", CommandCategory.CART);
        this.conn = conn;
    }

    @Override
    public void run(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!InfoManager.isLoggedIn()) {
            System.out.println("Only logged in users can have carts.  Use /sign-up or /login");
            return;
        }

        try {
            System.out.print("Book ID: ");
            int bookId = Integer.parseInt(scanner.nextLine());

            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Cart cart = InfoManager.getCurrentUser().getCart(conn);
            cart.addItem(conn, bookId, quantity);

            GetBookById getBook = new GetBookById(conn, bookId);
            Book book = getBook.get();

            System.out.printf("Added %d of %s to the cart.\n", quantity, book.getTitle());
        }
        catch (NumberFormatException e) {
            System.out.println("Error: input was not a valid integer!");
        }
        catch (SQLException e) {
            System.out.println("Was unable to add the item to the cart.");
        }

    }

    @Override
    protected String getDescription() {
        return "Adds a book to the cart.";
    }
}
