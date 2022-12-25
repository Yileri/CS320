import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;




public class TestDB {
    //        Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306", "1JMibyaVTO", "6hX7WHl7uj");
//    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://library320.ctolwwjuo2op.eu-central-1.rds.amazonaws.com:3306/sys";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    @Test
    public void testAddBook() {
        // Create a new book object with test data
        Book book = new Book(123459, "Test Book", 2020, "Test Genre", "Test Author", false);

        // Call the addBook method with the test book object
        Library.addBook(book);

        // Establish a connection to the database
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a prepared statement to retrieve the newly added book from the Books table
            String sql = "SELECT * FROM Book WHERE productID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 123459);

            // Execute the prepared statement and retrieve the result set
            ResultSet rs = stmt.executeQuery();

            // Check that the result set contains exactly one row
            assertTrue(rs.next());

            // Check that the values in the row match the test data
            assertEquals(123459, rs.getInt("productID"));
            assertEquals("Test Book", rs.getString("productName"));
            assertEquals(2020, rs.getInt("year"));
            assertEquals("Test Genre", rs.getString("genre"));
            assertEquals("Test Author", rs.getString("authorName"));
            assertFalse(rs.getBoolean("isReserved"));

            // Check that there are no more rows in the result set
            assertFalse(rs.next());
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            Library.removeBook(book);
        }
    }

    @Test
    public void testRemoveBook() {
        // Add a new book to the Books table with test data
        Book book = new Book(123459, "Test Book", 2020, "Test Genre", "Test Author", false);


        // Call the removeBook method with the test book object
        Library.removeBook(book);

        // Establish a connection to the database
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a prepared statement to retrieve the book from the Books table
            String sql = "SELECT * FROM Book WHERE productID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 123459);

            // Execute the prepared statement and retrieve the result set
            ResultSet rs = stmt.executeQuery();

            // Check that the result set is empty
            assertFalse(rs.next());
        } catch (SQLException se) {
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
    public void testAddMovie() {
        // Create a new movie object with test data
        Movie movie = new Movie(222221, "Test Movie", 2020, "Test Genre", "Test Director", false);

        // Call the addMovie method with the test movie object
        Library.addMovie(movie);

        // Establish a connection to the database
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a prepared statement to retrieve the newly added movie from the Movies table
            String sql = "SELECT * FROM Movie WHERE productID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 222221);

            // Execute the prepared statement and retrieve the result set
            ResultSet rs = stmt.executeQuery();

            // Check that the result set contains exactly one row
            assertTrue(rs.next());


            // Check that the values in the row match the test data
            assertEquals(222221, rs.getInt("productID"));
            assertEquals("Test Movie", rs.getString("productName"));
            assertEquals(2020, rs.getInt("year"));
            assertEquals("Test Genre", rs.getString("genre"));
            assertEquals("Test Director", rs.getString("directorName"));
            assertFalse(rs.getBoolean("isReserved"));

            // Check that there are no more rows in the result set
            assertFalse(rs.next());
        } catch (SQLException se) {
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


    @Test
    public void testRemoveMovie() {
        // Add a new movie to the Movies table with test data
        Movie movie = new Movie(222221, "Test Movie", 2020, "Test Genre", "Test Director", false);


        // Call the removeMovie method with the test movie object
        Library.removeMovie(movie);

        // Establish a connection to the database
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a prepared statement to retrieve the movie from the Movies table
            String sql = "SELECT * FROM Movie WHERE productID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 222221);

            // Execute the prepared statement and retrieve the result set
            ResultSet rs = stmt.executeQuery();

            // Check that the result set is empty
            assertFalse(rs.next());
        } catch (SQLException se) {
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
    public void testReserveOrReturn() throws SQLException {
        // Add a book to the table using the addBook function
        // Add the book to the database
        Book book = new Book(56, "deneme2", 1925, "Novel", "F. Scott Fitzgerald",false);
        Library.addBook(book);
        String str = "2022-12-24";
        LocalDate date = LocalDate.parse(str);
        book.reserveOrReturn(date,date);
        Library.removeBook(book);

    }

    @Test
    public void testListBookGenres() {
        // Call the listBookGenres() method
        List<String> bookGenres = Library.listBookGenres();

        // Verify that the returned list is not null and not empty
        assertNotNull(bookGenres);
        assertTrue(bookGenres.size() > 0);

        // Verify that all elements in the list are strings that represent book genres
        for (String genre : bookGenres) {
            assertTrue(genre.matches("[\\w\\s]+"));
        }
    }
    @Test
    public void testRequested() throws SQLException {
    Library.RequestBook("American Psycho",1987,"","");
    }
    @Test
    public void testRequestedList() throws SQLException {
        List<Book> liste = Library.RequestBookList();
        System.out.println(liste); ;
    }

    @Test
    public void testgetAllBooks() throws SQLException {
        ArrayList<Book> liste = SelectionTool.getAllBooks();
        System.out.println(liste);
    }


    @Test
    public void testSignInSuccess() {
        // Test a valid sign in
        boolean result = Library.SignIn("kafanagöretakıl", 1);//value taken from User Table
        assertTrue(result);
    }

    @Test
    public void testSignInFailure() {
        // Test an invalid sign in
        boolean result = Library.SignIn("user1", 2);
        assertFalse(result);
    }

    @Test
    public void testListMovieYear() {
        // Call the listMovieYear() method
        List<String> movieYears = Library.listMovieYear();

        // Verify that the returned list is not null and not empty
        assertNotNull(movieYears);
        assertTrue(movieYears.size() > 0);

        // Verify that all elements in the list are strings that represent years in the correct format
        for (String year : movieYears) {
            assertTrue(year.matches("\\d{4}"));
        }
    }

        @Test
        public void testListBookYear() {
            // Call the listBookYear() method
            List<String> bookYears = Library.listBookYear();

            // Verify that the returned list is not null and not empty
            assertNotNull(bookYears);
            assertTrue(bookYears.size() > 0);

            // Verify that all elements in the list are strings that represent years in the correct format
            for (String year : bookYears) {
                assertTrue(year.matches("\\d{4}"));
            }
        }
        @Test
    public void testListMovieDirector() {
        // Call the listMovieDirector() method
        List<String> movieDirectors = Library.listMovieDirector();

        // Verify that the returned list is not null and not empty
        assertNotNull(movieDirectors);
        assertTrue(movieDirectors.size() > 0);

        // Verify that all elements in the list are strings that represent movie directors' names
        for (String director : movieDirectors) {
            assertTrue(director.matches("[\\w\\s]+"));
        }
    }
    @Test
    public void testListBookAuthor() {
        // Call the listBookAuthor() method
        List<String> bookAuthors = Library.listBookAuthor();

        // Verify that the returned list is not null and not empty
        assertNotNull(bookAuthors);
        assertTrue(bookAuthors.size() > 0);

        // Verify that all elements in the list are strings that represent book authors' names
        for (String author : bookAuthors) {
            assertTrue(author.matches("[\\w\\s]+"));
        }
    }
    @Test
    public void testListMovieGenres() {
        // Call the listMovieGenres() method
        List<String> movieGenres = Library.listMovieGenres();

        // Verify that the returned list is not null and not empty
        assertNotNull(movieGenres);
        assertTrue(movieGenres.size() > 0);

        // Verify that all elements in the list are strings that represent movie genres
        for (String genre : movieGenres) {
            assertTrue(genre.matches("[\\w\\s]+"));
        }
    }
}

