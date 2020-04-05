package queries.publisher;

import adt.sql.BuildableQuery;
import adt.sql_tables.BankAccount;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetPublisherBankAccount extends BuildableQuery<BankAccount> {

    public GetPublisherBankAccount(Connection conn, Integer publisherId) throws SQLException {
        super(conn, "publisher/get_publisher_bank_acc.sql");
        build(publisherId);
    }


    @Override
    public BankAccount get() throws SQLException {
        ResultSet rs = execute();

        if (rs.next()) {
            return new BankAccount(rs);
        }
        else {
            return null;
        }
    }

}
