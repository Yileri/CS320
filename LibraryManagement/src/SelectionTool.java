import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class SelectionTool {
    private static final String DB_URL = "jdbc:mysql://library320.ctolwwjuo2op.eu-central-1.rds.amazonaws.com:3306/sys";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";


    public static ArrayList<Book> getAllBooks(){
        ArrayList<Book> books=new ArrayList<Book>();

        try{
            // Load the JDBC driver


            // Connect to the database
            Connection connection=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            // Create a statement
            Statement statement=connection.createStatement();

            // Execute the query
            ResultSet resultSet=statement.executeQuery("SELECT * FROM Book");

            // Iterate over the result set and add each book to the ArrayList
            while(resultSet.next()){
                int productID=resultSet.getInt("productID");
                String productName=resultSet.getString("productName");
                int year=resultSet.getInt("year");
                String genre=resultSet.getString("genre");
                String authorName = resultSet.getString("authorName");
                boolean isReserved = resultSet.getBoolean("isReserved");

                Book book=new Book(productID,productName,year,genre,authorName,isReserved);
                books.add(book);
            }

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return books;
    }

    public static ArrayList<Movie> getAllMovies(){
        ArrayList<Movie> movies=new ArrayList<Movie>();

        try{
            // Load the JDBC driver


            // Connect to the database
            Connection connection=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);

            // Create a statement
            Statement statement=connection.createStatement();

            // Execute the query
            ResultSet resultSet=statement.executeQuery("SELECT * FROM Movie");

            // Iterate over the result set and add each book to the ArrayList
            while(resultSet.next()){
                int productID=resultSet.getInt("productID");
                String productName=resultSet.getString("productName");
                int year=resultSet.getInt("year");
                String genre=resultSet.getString("genre");
                String directorName = resultSet.getString("directorName");
                boolean isReserved = resultSet.getBoolean("isReserved");

                Movie movie=new Movie(productID,productName,year,genre,directorName,isReserved);
                movies.add(movie);
            }

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return movies;
    }
}