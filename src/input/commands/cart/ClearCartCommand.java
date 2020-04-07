package input.commands.cart;

import input.InfoManager;
import input.commands.Command;
import input.commands.CommandCategory;
import inserts.clear_cart.ClearCart;

import java.sql.Connection;
import java.sql.SQLException;

public class ClearCartCommand extends Command {

    private Connection conn;

    public ClearCartCommand(Connection conn) {
        super("/clear-cart", CommandCategory.CART);
        this.conn = conn;
    }

    @Override
    public void run(String[] args) {
        if (!InfoManager.isLoggedIn()) {
            System.out.println("Only logged in users can have carts.  Use /sign-up or /login");
            return;
        }

        try {
            int cartId = InfoManager.getCurrentUser().getCart(conn).getId();
            ClearCart clearCart = new ClearCart(conn, cartId);
            clearCart.executeUpdate();

            System.out.println("Cleared the cart.");
        }
        catch (SQLException e) {
            System.out.println("Unable to clear the cart.");
        }

    }

    @Override
    protected String getDescription() {
        return "Clears the user's cart.";
    }
}
