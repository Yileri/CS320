import java.sql.*;
import java.time.LocalDate;

public class Movie extends Product{
    private static final String DB_URL ="jdbc:mysql://library320.ctolwwjuo2op.eu-central-1.rds.amazonaws.com:3306/sys";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    private String directorName;

    public Movie(int productID, String productName, int year, String genre, String Name,boolean isReserved) {
        super(productID,productName, year,genre,isReserved);
        this.directorName=Name;
    }
    public void reserveOrReturn(LocalDate DateBorrowed, LocalDate DateDue) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Insert a new book into the Movie table
            String sql = "UPDATE Movie SET dateBorrowed=?,dateDue=?, isReserved=? WHERE productID=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, Date.valueOf(DateBorrowed));
            pstmt.setDate(2, Date.valueOf(DateDue));
            pstmt.setBoolean(3,true);
            pstmt.setInt(4,getProductID());
            pstmt.executeUpdate();
            this.setIsReserved(true);
            if(DateDue==null){
                this.setIsReserved(false);
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




    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}


