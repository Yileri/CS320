import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Library {
    private static final String DB_URL ="jdbc:mysql://library320.ctolwwjuo2op.eu-central-1.rds.amazonaws.com:3306/sys";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";



    public static void addBook(Book book) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a prepared statement to insert the new book into the Books table

            String sql = "INSERT INTO Book (productID, productName,year,borrower,genre,authorName,dateBorrowed,dateDue,isReserved) VALUES (?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            // Set the values for the prepared statement
            stmt.setInt(1,book.getProductID());
            stmt.setString(2, book.getProductName());
            stmt.setInt(3, book.getYear());
            stmt.setString(4, null);

            stmt.setString(5, book.getGenre());
            stmt.setString(6,book.getAuthorName());
            stmt.setDate(7, null);
            stmt.setDate(8, null);
            stmt.setBoolean(9, book.getIsReserved());



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

    public void addMovie(Movie movie) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a prepared statement to insert the new book into the Books table

            String sql = "INSERT INTO Movie (productID, productName,year,borrower,dateBorrowed,dateDue,genre,directorName,isReserved) VALUES (?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);

            // Set the values for the prepared statement
            stmt.setInt(1,movie.getProductID());
            stmt.setString(2, movie.getProductName());
            stmt.setInt(3, movie.getYear());
            stmt.setString(4, null);

            stmt.setString(5, movie.getGenre());
            stmt.setString(6,movie.getDirectorName());
            stmt.setDate(7, null);
            stmt.setDate(8, null);
            stmt.setBoolean(9, movie.getIsReserved());



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


    public static void removeBook(Book book) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "DELETE FROM Book WHERE productID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, book.getProductID());
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

    public void removeMovie(Movie movie) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "DELETE FROM Movie WHERE productID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, movie.getProductID());
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


    public void findBook(int productID, Connection conn) {
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "SELECT * FROM Books WHERE productID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int year = rs.getInt("year");
                String productName = rs.getString("productName");
                String genre = rs.getString("genre");
                String authorName = rs.getString("authorName");

                // Do something with the retrieved book information
            } else {
                System.out.println("Book not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void findMovie(int productID, Connection conn) {
        try {
            String sql = "SELECT * FROM Movies WHERE productID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int year = rs.getInt("year");
                String productName = rs.getString("productName");
                String genre = rs.getString("genre");
                String directorName = rs.getString("directorName");

                // Do something with the retrieved movie information
            } else {
                System.out.println("Movie not found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static boolean SignIn(String UserName, int id) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT userID,userName FROM User WHERE userID = ? AND userName = ?";
           PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, UserName);
            ResultSet resultSet=pstmt.executeQuery();
            while(resultSet.next()){
                if(resultSet.getInt("userID")==id && resultSet.getString("userName").equals(UserName)){
                    return true;
                }
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
            return false;
        }
        public static List<String> listBookGenres(){
            List<String> genres =new Vector();
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                // Delete the book from the Books table
                String sql = "SELECT DISTINCT genre FROM Book";
                Statement pstmt = conn.createStatement();
                ResultSet resultSet=pstmt.executeQuery(sql);
                while(resultSet.next()) {
                 genres.add(resultSet.getString("genre"));
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
            return genres;
        }
    public static List<String> listMovieGenres(){
        List<String> genres =new Vector();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT DISTINCT genre FROM Movie";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()) {
                genres.add(resultSet.getString("genre"));
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
        return genres;
    }
    public static List<String> listBookAuthor(){
        List<String> genres =new Vector();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT DISTINCT authorName FROM Book";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()) {
                genres.add(resultSet.getString("authorName"));
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
        return genres;
    }
    public static List<String> listMovieDirector(){
        List<String> genres =new Vector();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT DISTINCT directorName FROM Movie";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()) {
                genres.add(resultSet.getString("directorName"));
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
        return genres;
    }
    public static List<String> listBookYear(){
        List<String> genres =new Vector();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT DISTINCT year FROM Book";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()) {
                genres.add(resultSet.getString("year"));
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
        return genres;
    }
    public static List<String> listMovieYear(){
        List<String> genres =new Vector();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT DISTINCT year FROM Movie";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()) {
                genres.add(resultSet.getString("year"));
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
        return genres;
    }
    public static void RequestBook(String name,String year,String authorName,String genre){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Create a prepared statement to insert the new book into the Books table
            String sql = "INSERT INTO RequestedBook (name,year,authorName,genre) VALUES (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, year);
            stmt.setString(3, authorName);
            stmt.setString(4, genre);
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


    public static void RequestMovie(String name,String year,String authorName,String genre){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Create a prepared statement to insert the new book into the Books table
            String sql = "INSERT INTO RequestedMovie(name,year,authorName,genre) VALUES (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, year);
            stmt.setString(3, authorName);
            stmt.setString(4, genre);

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
    public static ArrayList<Book> RequestBookList(){
        ArrayList<Book> request =new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT name FROM RequestedBook";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()){
                Random rand = new Random();
                int upperbound = 10000;
                int random = rand.nextInt(upperbound);
                String name=resultSet.getString("name");
                int year=resultSet.getInt("year");
                String genre=resultSet.getString("genre");
                String authorName = resultSet.getString("directorName");
                Book book=new Book(random,name,year,genre,authorName,false);
               request.add(book);
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
        return request;
    }
    public static ArrayList<Movie> RequestMovieList(){
        ArrayList<Movie> request =new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT name FROM RequestedMovie";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()){
                Random rand = new Random();
                int upperbound = 10000;
                int random = rand.nextInt(upperbound);
                String name=resultSet.getString("name");
                int year=resultSet.getInt("year");
                String genre=resultSet.getString("genre");
                String directorName = resultSet.getString("directorName");
                Movie movie=new Movie(random,name,year,genre,directorName,false);
                request.add(movie);
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
        return request;
    }
    public static ArrayList<String> searchByName(){
        ArrayList<String> search=new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT DISTINCT productName FROM Book";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()) {
                search.add(resultSet.getString("productName"));
            }
            String sql2 = "SELECT DISTINCT productName FROM Movie";
            Statement stmt = conn.createStatement();
            ResultSet resultSet2=pstmt.executeQuery(sql);
            while(resultSet.next()) {
                search.add(resultSet2.getString("productName"));
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
        return search;
    }

        }




