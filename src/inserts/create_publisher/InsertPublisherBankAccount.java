package inserts.create_publisher;

import adt.sql.Insert;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertPublisherBankAccount extends Insert {

    public InsertPublisherBankAccount(Connection conn, int bankAccId, int publisherId) throws SQLException {
        super(conn, "create_publisher/insert_publisher_bank_acc.sql");
        setParams(bankAccId, publisherId);
    }

}
