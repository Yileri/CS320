import java.sql.*;


public class Reserve {

    private static final String DB_URL ="jdbc:mysql://remotemysql.com:3306" ;
    private static final String PASS ="6hX7WHl7uj" ;
    private static final String USERNAME = "1JMibyaVTO";


    private int productID;
    private String productName;
    private String borrower;
    private String dateBorrowed;
    private String dateDue;
    private  boolean isReserved;



    public void create(int productID, String productName, int year, String genre, String authorName, String directorName) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);

            // Insert a new book into the Books table
            String sql = "INSERT INTO Books (productID, productName, year, genre, authorName) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productID);
            pstmt.setString(2, productName);
            pstmt.setInt(3, year);
            pstmt.setString(4, genre);
            pstmt.setString(5, authorName);
            pstmt.executeUpdate();

            // Insert a new movie into the Movies table
            sql = "INSERT INTO Movies (productID, productName, year, genre, directorName) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productID);
            pstmt.setString(2, productName);
            pstmt.setInt(3, year);
            pstmt.setString(4, genre);
            pstmt.setString(5, directorName);
            pstmt.executeUpdate();

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
    public void update(int productID, String productName, int year, String genre, String authorName, String directorName, boolean isReserved) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);

            // Update the book in the Books table
            String sql = "UPDATE Books SET productName = ?, year = ?, genre = ?, authorName = ?, isReserved = ? WHERE productID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productName);
            pstmt.setInt(2, year);
            pstmt.setString(3, genre);
            pstmt.setString(4, authorName);
            pstmt.setBoolean(5, isReserved);
            pstmt.setInt(6, productID);
            pstmt.executeUpdate();

            // Update the movie in the Movies table
            sql = "UPDATE Movies SET productName = ?, year = ?, genre = ?, directorName = ?, isReserved = ? WHERE productID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productName);
            pstmt.setInt(2, year);
            pstmt.setString(3, genre);
            pstmt.setString(4, directorName);
            pstmt.setBoolean(5, isReserved);
            pstmt.setInt(6, productID);
            pstmt.executeUpdate();

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

    public void Reserve(int productID, String productName, String borrower, String dateBorrowed, String dateDue) {
    }


}
