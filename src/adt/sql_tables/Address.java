package adt.sql_tables;

import adt.InputParser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Address extends SQLObject {

    private String postalCode;
    private String unit;
    private int streetNum;
    private String street;
    private String city;
    private String state;
    private String country;

    public Address(ResultSet rs) throws SQLException {
        id = rs.getInt("address_id");
        unit = rs.getString("unit");
        streetNum = rs.getInt("street_num");
        street = rs.getString("street");
        city = rs.getString("city");
        state = rs.getString("state");
        country = rs.getString("country");
    }

    public Address(String pCode, String unit, int streetNum, String street, String city, String state, String country) {
        this.postalCode = pCode;
        this.unit = unit;
        this.streetNum = streetNum;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public static Address createFromUserInputs() {
        InputParser parser = new InputParser(System.in);

        String unit = parser.getNextString("Unit: ", false);
        Integer streetNum = parser.getNextInt("Street Number: ", true);
        String streetName = parser.getNextString("Street Name: ", true);
        String city = parser.getNextString("City: ", true);
        String state = parser.getNextString("State: ", true);
        String country = parser.getNextString("Country: ", true);
        String pCode = parser.getNextString("Postal Code: ", true);

        return new Address(pCode, unit, streetNum, streetName, city, state, country);
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getUnit() {
        return unit;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }


    @Override
    public String toString() {
        String formatString;
        if (unit != null && !unit.isEmpty()) {
            formatString = "Unit %d, %d %s, %s, %s, %s (%s)";
            return String.format(formatString, unit, streetNum, street, city, state, country, postalCode);
        }
        else {
            formatString = "%d %s, %s, %s, %s (%s)";
            return String.format(formatString, streetNum, street, city, state, country, postalCode);
        }
    }
}
