import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Staff extends User{

    private static final String DB_URL ="jdbc:mysql://remotemysql.com:3306" ;
    private static final String PASS ="6hX7WHl7uj" ;
    private static final String USERNAME = "1JMibyaVTO";



    Staff (int userID, String userName, String userType){
        super(userID,userName);
        userType="staff";
    }
    public void create(int userID, String userName, String userType) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306", USERNAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Insert the new user into the users table
        String sql = "INSERT INTO Users (user_id, user_name, user_type) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            pstmt.setString(2, userName);
            pstmt.setString(3, userType);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int userID, String userName, String userType) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306", USERNAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Update the user in the users table
        String sql = "UPDATE Users SET user_name = ?, user_type = ? WHERE user_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setString(2, userType);
            pstmt.setInt(3, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
