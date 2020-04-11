package adt.sql_tables;

import queries.GetItemsInOrder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order extends SQLObject {

    private Timestamp placedDate;
    private Timestamp shippedDate;
    private Timestamp estimatedDelivery;
    private boolean delivered;

    public Order(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("order_id");
        placedDate = rs.getTimestamp("placed_date");
        shippedDate = rs.getTimestamp("shipped_date");
        estimatedDelivery = rs.getTimestamp("estimated_delivery");
        delivered = rs.getBoolean("delivered");
    }

    public ArrayList<SoldItem> getItems(Connection conn) throws SQLException {
        GetItemsInOrder query = new GetItemsInOrder(conn, id);
        return query.get();
    }

    public BillingInfo getBillingInfo() {
        // TODO: Add query to get order's billing info
        return null;
    }

    public ShippingInfo getShippingInfo() {
        // TODO: Add query to get order's shipping info
        return null;
    }

    public Timestamp getPlacedDate() {
        return placedDate;
    }

    public Timestamp getShippedDate() {
        return shippedDate;
    }

    public Timestamp getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public boolean isDelivered() {
        return delivered;
    }


    public String toString(Connection conn) throws SQLException {
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");

        String placedStr = dateFormatter.format(placedDate.toLocalDateTime());
        String estimatedStr;
        if (estimatedDelivery != null) {
            estimatedStr = dateFormatter.format(estimatedDelivery.toLocalDateTime());
        }
        else {
            estimatedStr = "none";
        }

        String formatStr = "Order %3d | Delivered: %b | Placed: %11s | Estimated Delivery: %11s\n";
        sb.append(String.format(formatStr, id, delivered, placedStr, estimatedStr));

        for (SoldItem item : getItems(conn)) {
            sb.append('\t');
            sb.append(item.toString(conn));
            sb.append('\n');
        }

        return sb.toString();
    }
}
