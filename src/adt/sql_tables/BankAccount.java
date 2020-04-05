package adt.sql_tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccount extends SQLObject {

    private int bankNum;
    private int branchNum;
    private String accountNum;

    public BankAccount(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("bank_acc_id");
        bankNum = rs.getInt("bank_num");
        branchNum = rs.getInt("branch_num");
        accountNum = rs.getString("account_num");
    }

    public BankAccount(int bankNum, int branchNum, String accountNum) {
        this.bankNum = bankNum;
        this.branchNum = branchNum;
        this.accountNum = accountNum;
    }

    public int getBankNum() {
        return bankNum;
    }

    public int getBranchNum() {
        return branchNum;
    }

    public String getAccountNum() {
        return accountNum;
    }
}
