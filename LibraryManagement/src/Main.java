import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306", "1JMibyaVTO", "6hX7WHl7uj");


//// Create a statement
//        Statement stmt = conn.createStatement();
//
//// Execute a query
//        ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");
//
//// Loop through the result set
//        while (rs.next()) {
//            // Retrieve data from a column in the current row
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//
//            // Do something with the data...
//        }

//// Close the result set, statement, and connection
//        rs.close();
//        stmt.close();


            conn.close();
    }
}