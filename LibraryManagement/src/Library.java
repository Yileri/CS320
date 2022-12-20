import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Library {
    private static final String DB_URL ="jdbc:mysql://remotemysql.com:3306" ;
    private static final String PASS ="6hX7WHl7uj" ;
    private static final String USERNAME = "1JMibyaVTO";




        public void addBook(int productID, String productName, int year, String genre, String authorName, boolean isReserved) {
            Connection conn = null;
            PreparedStatement stmt = null;
            try {
                // Establish a connection to the database
                conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);

                // Create a prepared statement to insert the new book into the Books table
                String sql = "INSERT INTO Books (productID, productName, year, genre, authorName,isReserved) VALUES (?, ?, ?, ?, ?,?)";
                stmt = conn.prepareStatement(sql);

                // Set the values for the prepared statement
                stmt.setInt(1, productID);
                stmt.setString(2, productName);
                stmt.setInt(3, year);
                stmt.setString(4, genre);
                stmt.setString(5, authorName);
                stmt.setBoolean(6,isReserved);

                // Execute the prepared statement
                stmt.executeUpdate();
            } catch (SQLException se) {
                // Handle errors for JDBC
                se.printStackTrace();
            } finally {
                // Close resources
                try {
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }

    public void addMovie(int productID, String productName, int year, String genre, String directorName, boolean isReserved) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);

            // Create a prepared statement to insert the new book into the Books table
            String sql = "INSERT INTO Books (productID, productName, year, genre, directoName,isReserved) VALUES (?, ?, ?, ?, ?,?)";
            stmt = conn.prepareStatement(sql);

            // Set the values for the prepared statement
            stmt.setInt(1, productID);
            stmt.setString(2, productName);
            stmt.setInt(3, year);
            stmt.setString(4, genre);
            stmt.setString(5, directorName);
            stmt.setBoolean(6,isReserved);

            // Execute the prepared statement
            stmt.executeUpdate();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }





    public void remove(){

    }

    public void find(){

    }
}
