package inserts.create_purchase_order;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBookInPurchaseOrder extends Insert {

    public InsertBookInPurchaseOrder(Connection conn, Integer poId, Integer bookId) throws SQLException {
        super(conn, "create_purchase_order/insert_book_in_po.sql");
        setParams(poId, bookId);
    }

}
