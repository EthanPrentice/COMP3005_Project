package updates.create_purchase_order;

import adt.sql.MultiUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreatePurchaseOrder implements MultiUpdate {

    private Connection conn;
    private int bookId;
    private int quantity;
    private int pricePerUnit;

    private Integer purchaseOrderId = null;

    public CreatePurchaseOrder(Connection conn, int bookId, int quantity, int pricePerUnit) {
        this.conn = conn;
        this.bookId = bookId;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public void executeUpdates() throws SQLException {
        executeUpdates(true);
    }

    @Override
    public void executeUpdates(boolean commit) throws SQLException {

        InsertPurchaseOrder insertPurchaseOrder = new InsertPurchaseOrder(conn, quantity, pricePerUnit);
        insertPurchaseOrder.executeUpdate(false);

        int purchaseOrderId;
        ResultSet rs = insertPurchaseOrder.getGeneratedKeys();
        if (rs.next()) {
            purchaseOrderId = rs.getInt(1);
        }
        else {
            throw new SQLException("Could not insert new purchase order. Rolling back.");
        }

        InsertBookInPurchaseOrder insertBookInPO = new InsertBookInPurchaseOrder(conn, purchaseOrderId, bookId);
        insertBookInPO.executeUpdate(false);

        this.purchaseOrderId = purchaseOrderId;
        if (commit) {
            conn.commit();
        }
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }
}
