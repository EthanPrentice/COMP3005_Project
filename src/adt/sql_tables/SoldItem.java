package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SoldItem extends SQLObject {

    private int pricePerUnit;
    private int quantity;

    public SoldItem(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("sold_item_id");
        pricePerUnit = rs.getInt("price_per_unit");
        quantity = rs.getInt("quantity");
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSubtotal() {
        return pricePerUnit * quantity;
    }

}
