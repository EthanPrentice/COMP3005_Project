package adt.sql_tables;

import queries.cart.GetCart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User extends SQLObject {

    private String username;
    private String email;
    private boolean isAdmin;

    private BillingInfo defaultBilling;
    private ShippingInfo defaultShipping;

    public User(ResultSet rs) throws SQLException {
        super(rs);

        id = rs.getInt("user_id");
        username = rs.getString("username");
        email = rs.getString("email");
        isAdmin = rs.getBoolean("is_admin");

        // TODO: Change below to queries in getters
//        defaultBilling = new BillingInfo(rs);
//        defaultShipping = new ShippingInfo(rs);

//        cart = new Cart(rs);
    }

    private ArrayList<PhoneNumber> getPhoneNumbers(Connection conn) throws SQLException {
        // TODO: implement to run query getting user phone numbers
        return null;
    }

    private ArrayList<Order> getOrders(Connection conn) throws SQLException {
        // TODO: implement to run query getting user orders
        return null;
    }

    public Cart getCart(Connection conn) throws SQLException {
        GetCart getCart = new GetCart(conn, id);
        return getCart.get();
    }

    @Override
    public String toString() {
        String formatStr = "User(%3d, %s, %s, %b)";
        return String.format(formatStr, id, username, email, isAdmin);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
