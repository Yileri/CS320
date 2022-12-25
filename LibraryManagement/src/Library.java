import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Library {
    private static final String DB_URL ="jdbc:mysql://library320.ctolwwjuo2op.eu-central-1.rds.amazonaws.com:3306/sys";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    static boolean isSignedIn = false;


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

    public static void addMovie(Movie movie) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a prepared statement to insert the new book into the Books table

            /*
            tring sql = "INSERT INTO Book (productID, productName,year,borrower,genre,authorName,dateBorrowed,dateDue,isReserved) VALUES (?,?,?,?,?,?,?,?,?)";
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
             */


            String sql = "INSERT INTO Movie (productID, productName,year,borrower,genre, directorName, dateBorrowed, dateDue, isReserved) VALUES (?,?,?,?,?,?,?,?,?)";
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

    public static void removeMovie(Movie movie) {
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
                    isSignedIn = true;
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
    public static void RequestBook(String name,int year,String authorName,String genre){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Create a prepared statement to insert the new book into the Books table
            String sql = "INSERT INTO RequestedBook (name,year,authorName,genre) VALUES (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, year);
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


    public static void RequestMovie(String name,int year,String authorName,String genre){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Create a prepared statement to insert the new book into the Books table
            String sql = "INSERT INTO RequestedMovie(name,year,authorName,genre) VALUES (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, year);
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
            String sql = "SELECT * FROM RequestedBook";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()){
                Random rand = new Random();
                int upperbound = 10000;
                int random = rand.nextInt(upperbound);
                String name=resultSet.getString("name");
                int year=resultSet.getInt("year");
                String genre=resultSet.getString("genre");
                String authorName = resultSet.getString("authorName");
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
            String sql = "SELECT * FROM RequestedMovie";
            Statement pstmt = conn.createStatement();
            ResultSet resultSet=pstmt.executeQuery(sql);
            while(resultSet.next()){
                Random rand = new Random();
                int upperbound = 10000;
                int random = rand.nextInt(upperbound);
                String name=resultSet.getString("name");
                int year=resultSet.getInt("year");
                String genre=resultSet.getString("genre");
                String directorName = resultSet.getString("authorName");
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
    public static ArrayList<String> searchByName(String name){
        ArrayList<String> search=new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Delete the book from the Books table
            String sql = "SELECT productName FROM Book WHERE productName=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet resultSet=pstmt.executeQuery();
            while(resultSet.next()) {
                search.add(resultSet.getString("productName"));
            }
            String sql2 = "SELECT productName FROM Movie WHERE productName=?";
            PreparedStatement stmt = conn.prepareStatement(sql2);
            stmt.setString(1, name);
            ResultSet resultSet2=stmt.executeQuery();
            while(resultSet2.next()) {
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
    public static ArrayList<Movie> FilterMovie(int year,String directorName,String genre){
       ArrayList<Movie> filter =new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Create a prepared statement to insert the new book into the Books table
                String sql = "SELECT * FROM Movie  WHERE year=? AND genre=? AND directorName=? ";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, year);
                stmt.setString(2, genre);
                stmt.setString(3, directorName);
                ResultSet resultSet=stmt.executeQuery();
                while(resultSet.next()){
                    int id3= resultSet.getInt("productID");
                    String name3=resultSet.getString("productName");
                    int year3=resultSet.getInt("year");
                    String genre3=resultSet.getString("genre");
                    String directorName3 = resultSet.getString("directorName");
                    Movie movie=new Movie(id3,name3,year3,genre3,directorName3,false);
                    filter.add(movie);

            }

            // Execute the prepared statement
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
        return filter;
    }
    public static ArrayList<Book> FilterBook(int year,String directorName,String genre){
        ArrayList<Book> filter =new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Create a prepared statement to insert the new book into the Books table

                String sql = "SELECT * FROM Book  WHERE year=? AND genre=? AND authorName=?";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, year);
                stmt.setString(2, genre);
                stmt.setString(3, directorName);
                ResultSet resultSet=stmt.executeQuery();
                while(resultSet.next()){
                    int id2= resultSet.getInt("productID");
                    String name2=resultSet.getString("productName");
                    int year2=resultSet.getInt("year");
                    String genre2=resultSet.getString("genre");
                    String directorName2 = resultSet.getString("authorName");
                  Book book =new Book(id2,name2,year2,genre2,directorName2,false);
                    filter.add(book);

            }

            // Execute the prepared statement
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
        return filter;
    }

        }




