package queries.admin;

import adt.sql.Query;
import adt.views.BookSalesInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetPrevMonthSalesReport extends Query<ArrayList<BookSalesInfo>>{

    public GetPrevMonthSalesReport(Connection conn) throws SQLException {
        super(conn, "admin/get_prev_month_sales_report.sql");
    }

    @Override
    public ArrayList<BookSalesInfo> get() throws SQLException {
        ResultSet rs = execute();

        ArrayList<BookSalesInfo> bookSales = new ArrayList<>();
        while (rs.next()) {
            bookSales.add(new BookSalesInfo(rs));
        }

        return bookSales;
    }
}
