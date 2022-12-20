import java.sql.*;
public class Library {

    private static final String DB_URL ="jdbc:mysql://remotemysql.com:3306" ;
    private static final String PASS ="6hX7WHl7uj" ;
    private static final String USERNAME = "1JMibyaVTO";


    public void add(){



    }

    public void removeBook(int productID, String productName, int year, String genre, String authorName, boolean isReserved) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);

            // Delete the book from the Books table
            String sql = "DELETE FROM Books WHERE productID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productID);
            pstmt.executeUpdate();

            // If the book was reserved, delete the corresponding reservation from the Reservation table
            if (isReserved) {
                sql = "DELETE FROM Reservation WHERE productID = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, productID);
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeMovie(int productID, String productName, int year, String genre, String directorName, boolean isReserved) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);

            // Delete the book from the Books table
            String sql = "DELETE FROM Movies WHERE productID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productID);
            pstmt.executeUpdate();

            // If the book was reserved, delete the corresponding reservation from the Reservation table
            if (isReserved) {
                sql = "DELETE FROM Reservation WHERE productID = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, productID);
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void find(){

    }
}
