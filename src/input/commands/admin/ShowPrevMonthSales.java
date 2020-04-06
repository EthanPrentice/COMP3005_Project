package input.commands.admin;

import adt.views.BookSalesInfo;
import queries.admin.GetPrevMonthSalesReport;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShowPrevMonthSales extends AdminCommand {

    private Connection conn;

    public ShowPrevMonthSales(Connection conn) {
        super("/prev-month-sales");
        this.conn = conn;
    }

    @Override
    public void run(String[] args) {
        try {
            GetPrevMonthSalesReport getReport = new GetPrevMonthSalesReport(conn);
            ArrayList<BookSalesInfo> monthlyReport = getReport.get();

            DecimalFormat decimalFormat = new DecimalFormat("#####0.00");

            String headerFormat = "%7s | %-60s | %13s | %10s\n";
            System.out.format(headerFormat, "Book ID", "Book Title", "Sale Quantity", "Revenue");

            String formatString = "%7d | %-60s | %13d | $%9s\n";
            for (BookSalesInfo salesInfo : monthlyReport) {
                String salesRevenue = decimalFormat.format(salesInfo.getSalesRevenue());
                System.out.printf(formatString, salesInfo.getId(), salesInfo.getBookTitle(), salesInfo.getSalesQuantity(), salesRevenue);
            }

        }
        catch(SQLException e) {
            System.err.println("There was an error getting the report.");
        }
    }

    @Override
    protected String getDescription() {
        return "Shows the previous month's sales report";
    }
}
