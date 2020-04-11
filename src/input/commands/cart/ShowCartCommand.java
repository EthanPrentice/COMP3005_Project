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

            System.out.println(cart.toString(conn));
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
