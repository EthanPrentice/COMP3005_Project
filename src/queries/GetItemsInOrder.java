package queries;

import adt.sql.BuildableQuery;
import adt.sql.Query;
import adt.sql_tables.SoldItem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetItemsInOrder extends BuildableQuery {

    public GetItemsInOrder(Connection conn, Integer orderId) throws SQLException {
        super(conn, "get_items_in_order.sql");
        build(orderId);
    }


    public ArrayList<SoldItem> getItems() throws SQLException {
        ResultSet rs = execute();

        ArrayList<SoldItem> items = new ArrayList<>();

        while (rs.next()) {
            items.add(new SoldItem(rs));
        }

        return items;
    }


}
