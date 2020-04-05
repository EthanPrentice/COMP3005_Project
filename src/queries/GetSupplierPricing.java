package queries;

import adt.sql.BuildableQuery;
import adt.sql_tables.SupplierPricing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetSupplierPricing extends BuildableQuery<SupplierPricing> {

    public GetSupplierPricing(Connection conn, Integer bookId) throws SQLException {
        super(conn, "get_supplier_pricing.sql");
        build(bookId);
    }

    @Override
    public SupplierPricing get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new SupplierPricing(rs);
        }
        else {
            return null;
        }
    }
}
