package inserts.create_publisher;

import adt.sql.Update;
import adt.sql_tables.BankAccount;

import java.sql.Connection;
import java.sql.SQLException;

public class InsertBankAccount extends Update {

    public InsertBankAccount(Connection conn, int bankNum, int branchNum, int accountNum) throws SQLException {
        super(conn, "create_publisher/insert_bank_acc.sql");
        setParams(bankNum, branchNum, accountNum);
    }

    public InsertBankAccount(Connection conn, BankAccount bankAccount) throws SQLException {
        super(conn, "create_publisher/insert_bank_acc.sql");
        setParams(bankAccount.getBankNum(), bankAccount.getBranchNum(), bankAccount.getAccountNum());
    }

}
