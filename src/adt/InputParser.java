package adt;

import java.io.InputStream;
import java.util.Scanner;

public class InputParser {

    private Scanner scanner;

    public InputParser(InputStream inStream) {
        this.scanner = new Scanner(inStream);
    }

    public String getNextString(String query, boolean required) {
        if (required) {
            query = "*" + query;
        }

        System.out.print(query);
        String tmp = scanner.nextLine();

        while (required && tmp.trim().isEmpty()) {
            System.out.println("This field is required.\n");

            System.out.print(query);
            tmp = scanner.nextLine();
        }

        if (!required && tmp.trim().isEmpty()) {
            return null;
        }

        return tmp.trim();
    }

    public Integer getNextInt(String query, boolean required) throws NumberFormatException {
        if (required) {
            query = "*" + query;
        }

        while (true) {
            System.out.print(query);
            String tmp = scanner.nextLine();

            while (required && tmp.trim().isEmpty()) {
                System.out.println("This field is required.\n");

                System.out.print(query);
                tmp = scanner.nextLine();
            }

            if (!required && tmp.trim().isEmpty()) {
                return null;
            }

            try {
                return Integer.parseInt(tmp.trim());
            }
            catch (NumberFormatException e) {
                System.out.println("Input must be an integer.\n");
            }
        }
    }

    public Float getNextFloat(String query, boolean required) throws NumberFormatException {
        if (required) {
            query = "*" + query;
        }

        while (true) {
            System.out.print(query);
            String tmp = scanner.nextLine();

            while (required && tmp.trim().isEmpty()) {
                System.out.println("This field is required.\n");

                System.out.print(query);
                tmp = scanner.nextLine();
            }

            if (!required && tmp.trim().isEmpty()) {
                return null;
            }

            try {
                return Float.parseFloat(tmp.trim());
            }
            catch (NumberFormatException e) {
                System.out.println("Input must be a float.\n");
            }
        }
    }
}
