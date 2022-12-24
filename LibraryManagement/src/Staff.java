import java.sql.*;
import java.util.ArrayList;

public class Staff extends User{

    private static final String DB_URL ="jdbc:mysql://library320.ctolwwjuo2op.eu-central-1.rds.amazonaws.com:3306/sys" ;
    private static final String PASS ="admin123" ;
    private static final String USERNAME = "admin";



    Staff (int userID, String userName){
        super(userID,userName);
        setUserType("Staff");
    }
    public void create() {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Insert the new user into the users table
        String sql = "INSERT INTO User (userID, userName, userType) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, getUserID());
            pstmt.setString(2, getUserName());
            pstmt.setString(3, getUserType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String newName) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Update the user in the users table
        String sql = "UPDATE User SET userName = ? WHERE userID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, getUserID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
