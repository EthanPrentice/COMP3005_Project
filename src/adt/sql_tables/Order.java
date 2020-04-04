package adt.sql_tables;

import queries.GetItemsInOrder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Order extends SQLObject {

    private Timestamp placedDate;
    private Timestamp shippedDate;
    private Timestamp estimatedDelivery;
    private boolean delivered;

    private BillingInfo billingInfo;
    private ShippingInfo shippingInfo;

    private User orderedBy;

    public Order(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("order_id");
        placedDate = rs.getTimestamp("placed_date");
        shippedDate = rs.getTimestamp("shipped_date");
        estimatedDelivery = rs.getTimestamp("estimate_delivery");
        delivered = rs.getBoolean("delivered");
    }

    public ArrayList<SoldItem> getItems(Connection conn) throws SQLException {
        GetItemsInOrder query = new GetItemsInOrder(conn, id);
        return query.getItems();
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
}
