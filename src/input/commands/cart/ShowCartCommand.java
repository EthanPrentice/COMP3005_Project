package input.commands.cart;

import adt.sql_tables.Book;
import adt.sql_tables.Cart;
import adt.sql_tables.CartItem;
import input.InfoManager;
import input.commands.Command;
import input.commands.CommandCategory;
import queries.cart.GetCart;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShowCartCommand extends Command {

    private Connection conn;

    public ShowCartCommand(Connection conn) {
        super("/show-cart", CommandCategory.CART);
        this.conn = conn;
    }

    @Override
    public void run(String[] args) {
        if (!InfoManager.isLoggedIn()) {
            System.out.println("Only logged in users can have carts.  Use /sign-up or /login");
            return;
        }

        try {
            GetCart getCart = new GetCart(conn, InfoManager.getCurrentUser().getId());
            Cart cart = getCart.get();

            ArrayList<CartItem> cartItems = cart.getItems(conn);

            if (cartItems.isEmpty()) {
                System.out.println("Cart is empty!");
                return;
            }

            String headerString = "%4s | %-60s | %6s | %8s | %8s\n";
            System.out.printf(headerString, "ID", "Book Title", "Price", "Quantity", "Subtotal");

            DecimalFormat decimalFormat = new DecimalFormat("##0.00");

            String formatString = "%4s | %-60s | %6s | %8s | %8s\n";
            for (int i = 0; i < cartItems.size(); ++i) {
                Book book = cartItems.get(i).getBook(conn);
                String priceString = decimalFormat.format(book.getPrice());
                String subtotalString = decimalFormat.format(cartItems.get(i).getSubtotal(conn));

                System.out.printf(formatString, (i + 1), book.getTitle(), priceString, cartItems.get(i).getQuantity(), subtotalString);
            }
        }
        catch (SQLException e) {
            System.out.println("Unable to access the user's cart.");
        }
    }

    @Override
    protected String getDescription() {
        return "Displays items in the user's cart.";
    }
}
