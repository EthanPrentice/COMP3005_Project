package queries.order;

import adt.sql.BuildableQuery;
import adt.sql_tables.Order;
import adt.sql_tables.SoldItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetUserOrders extends BuildableQuery<ArrayList<Order>> {

    public GetUserOrders(Connection conn, Integer userId) throws SQLException {
        super(conn, "order/get_user_orders.sql");
        build(userId);
    }


    @Override
    public ArrayList<Order> get() throws SQLException {
        ResultSet rs = execute();

        ArrayList<Order> orders = new ArrayList<>();

        while (rs.next()) {
            orders.add(new Order(rs));
        }

        return orders;
    }

}
