package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierPricing extends SQLObject {

    private float price;
    private float publisherRate;

    public SupplierPricing(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("supplier_pricing_id");
        price = rs.getFloat("purchase_price");
        publisherRate = rs.getFloat("publisher_rate");
    }

    public float getPrice() {
        return price;
    }

    public float getPublisherRate() {
        return publisherRate;
    }
}
