package inserts.create_user;

import adt.sql.MultiUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateUser implements MultiUpdate {

    private Connection conn;

    private String username;
    private String email;
    private String password;

    private Integer phoneId;
    private Integer billingInfoId;
    private Integer shippingInfoId;

    private Integer userId = null;

    public CreateUser(Connection conn, String username, String email, String password, Integer phoneId, Integer billingInfoId, Integer shippingInfoId) {
        this.conn = conn;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneId = phoneId;
        this.billingInfoId = billingInfoId;
        this.shippingInfoId = shippingInfoId;
    }


    private int insertUser() throws SQLException {
        InsertUser insertUser = new InsertUser(conn, username, email, password);
        insertUser.executeUpdate(false);

        ResultSet rs = insertUser.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not create new user.  Rolling back.");
        }
    }

    public int insertCart() throws SQLException {
        InsertCart insertCart = new InsertCart(conn);
        insertCart.executeUpdate(false);

        ResultSet rs = insertCart.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        else {
            conn.rollback();
            throw new SQLException("Could not create new cart.  Rolling back.");
        }
    }

    @Override
    public void executeUpdates() throws SQLException {
        executeUpdates(true);
    }

    @Override
    public void executeUpdates(boolean commit) throws SQLException {
        int userId = insertUser();
        int cartId = insertCart();

        InsertUserCart insertUserCart = new InsertUserCart(conn, userId, cartId);
        insertUserCart.executeUpdate(false);

        if (phoneId != null) {
            InsertUserPhone insertUserPhone = new InsertUserPhone(conn, phoneId, userId);
            insertUserPhone.executeUpdate(false);
        }

        if (billingInfoId != null) {
            InsertUserBilling insertUserBilling = new InsertUserBilling(conn, billingInfoId, userId);
            insertUserBilling.executeUpdate(false);
        }

        if (shippingInfoId != null) {
            InsertUserShipping insertUserShipping = new InsertUserShipping(conn, shippingInfoId, userId);
            insertUserShipping.executeUpdate(false);
        }

        this.userId = userId;
        if (commit) {
            conn.commit();
        }
    }
}
