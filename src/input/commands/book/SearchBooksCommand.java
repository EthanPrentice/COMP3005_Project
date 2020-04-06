package input.commands.book;

import adt.sql_tables.Book;
import input.commands.Command;
import queries.book.SearchBooks;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class SearchBooksCommand extends Command {

    private Connection conn;

    public SearchBooksCommand(Connection conn) {
        super("/search");
        this.conn = conn;
    }

    @Override
    public void run(String[] args) {
        if (args.length < 2) {
            System.out.println("Must provide a search term after the query.");
            return;
        }

        StringJoiner searchQuery = new StringJoiner(" ");
        for (int i = 1; i < args.length; ++i) {
            searchQuery.add(args[i]);
        }

        try {
            SearchBooks searchBooks = new SearchBooks(conn, searchQuery.toString());
            ArrayList<Book> books = searchBooks.get();

            String headerFormat = "%4s | %-7s | %-60s | %-35s | %-20s | %5s\n";
            System.out.format(headerFormat, "ID", "Price", "Title", "Author", "Genre", "Pages");

            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            String formatString = "%4d | $%6s | %-60s | %-35s | %-20s | %5d\n";
            for (Book book : books) {

                String formattedPrice = decimalFormat.format(book.getPrice());

                System.out.printf(formatString,
                    book.getId(),
                    formattedPrice,
                    book.getTitle(),
                    book.getAuthor(conn).getName().getShort(),
                    book.getGenre(),
                    book.getPageCount()
                );
            }

        }
        catch (SQLException e) {
            System.err.println("There was an error performing the search.");
        }
    }

    @Override
    protected String getDescription() {
        return null;
    }
}
