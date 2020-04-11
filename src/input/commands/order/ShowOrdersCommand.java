package input.commands.order;

import adt.sql_tables.Order;
import adt.sql_tables.SoldItem;
import adt.sql_tables.User;
import input.InfoManager;
import input.commands.Command;
import input.commands.CommandCategory;
import queries.order.GetUserOrders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowOrdersCommand extends Command {

    private Connection conn;

    public ShowOrdersCommand(Connection conn) {
        super("/show-orders", CommandCategory.ORDERS);
        this.conn = conn;
    }

    @Override
    public void run(String[] args) {
        if (!InfoManager.isLoggedIn()) {
            System.out.println("Only logged in users can have orders.  Use /sign-up or /login");
            return;
        }

        try {
            User currUser = InfoManager.getCurrentUser();

            GetUserOrders getOrders = new GetUserOrders(conn, currUser.getId());
            ArrayList<Order> orders = getOrders.get();

            if (orders.isEmpty()) {
                System.out.println("The user has no orders.");
            }

            // Undelivered first, then order by date placed
            orders.sort((order1, order2) -> {
                if (order1.isDelivered()) {
                    if (order2.isDelivered()) {
                        return order1.getPlacedDate().compareTo(order2.getPlacedDate());
                    }
                    else {
                        return 1;
                    }
                }
                else if (order2.isDelivered()) {
                    return -1;
                }
                else {
                    return order1.getPlacedDate().compareTo(order2.getPlacedDate());
                }
            });

            for (Order order : orders) {
                System.out.println(order.toString(conn));
            }

        }
        catch (SQLException e) {
            System.out.println("Unable to get the user's orders.");
        }

    }

    @Override
    protected String getDescription() {
        return "Outputs the user's orders to the screen.";
    }
}
