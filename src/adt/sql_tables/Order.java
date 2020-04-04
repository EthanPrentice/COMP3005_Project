package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Order extends SQLObject {

    private BillingInfo billingInfo;
    private ShippingInfo shippingInfo;

    private User orderedBy;

    public Order(ResultSet rs) throws SQLException {
        super(rs);
    }

    public ArrayList<SoldItem> getItems() {
        // TODO: implement with query
        return null;
    }

}
