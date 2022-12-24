import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;




public class TestDB {
    //        Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306", "1JMibyaVTO", "6hX7WHl7uj");
//    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://library320.ctolwwjuo2op.eu-central-1.rds.amazonaws.com:3306";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    @Test
    public void testJdbcConnection() {
        Connection conn = null;
        try {
            // Register the JDBC driver
//            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            fail(e.getMessage());
        } finally {
            // Close the connection
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                fail(e.getMessage());
            }
        }
    }

    @Test
    public void testAddBook() throws SQLException {
        // Add a book to the table using the addBook function
        Book book = new Book(41, "The Great Gatsby", 1925, "Novel", "F. Scott Fitzgerald",false);

        // Add the book to the database
        Library.addBook(book);


        // Connect to the database and retrieve the book

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a SELECT statement to retrieve the book
            rs = stmt.executeQuery("SELECT * FROM Book WHERE productID = 41");

            // Check that the book was added to the database
            assertEquals(book, rs);

        } catch (SQLException se) {
            fail(se.getMessage());
        } finally {
            // Close the resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Test
    public void testremoveBook() throws SQLException {
        // Add a book to the table using the addBook function
        Book book = new Book(42, "The Great Gatsby", 1925, "Novel", "F. Scott Fitzgerald",false);
        // Add the book to the database
        Library.addBook(book);
        Library.removeBook(book);
    }
   @Test
    public void testCreateStaff() throws SQLException {
        // Add a book to the table using the addBook function
        Staff staff = new Staff(1,"kafanagöretakıl");
        // Add the book to the database
        staff.create();
    }
  @Test
    public void testUpdateStaff() throws SQLException {
        // Add a book to the table using the addBook function
        Staff staff = new Staff(2,"takıl");
        // Add the book to the database
        staff.update("yorgun");
    }
    @Test
    public void testReserve() throws SQLException {
        // Add a book to the table using the addBook function
        // Add the book to the database
        Book book = new Book(56, "deneme2", 1925, "Novel", "F. Scott Fitzgerald",false);
        Library.addBook(book);
        String str = "2022-12-24";
        LocalDate date = LocalDate.parse(str);
        book.reserve("ekin",date,date);
        Library.removeBook(book);

    }
    @Test
    public void testList() throws SQLException {
        List<String> liste = Library.listBookGenres();
        System.out.println(liste);
    }
    @Test
    public void testRequested() throws SQLException {
    Library.Request("American Psycho","Book");
    }
    @Test
    public void testRequestedList() throws SQLException {
        List<String> liste = Library.RequestList();
        System.out.println(liste); ;
    }
    @Test
    public void testSıgnIn() throws SQLException {

        System.out.println(Library.SignIn("yorgun",1)); ;
    }
}
