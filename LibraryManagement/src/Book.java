import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Book extends Product{
    private static final String DB_URL ="jdbc:mysql://library320.ctolwwjuo2op.eu-central-1.rds.amazonaws.com:3306/sys";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    private String authorName;

    public Book(int productID, String productName, int year, String genre, String authorName,boolean isReserved){
        super(productID,productName, year,genre,isReserved);
        this.authorName=authorName;
    }
    public void reserveOrReturn(String Borrower , LocalDate DateBorrowed, LocalDate DateDue) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Insert a new book into the Books table
            String sql = "UPDATE Book SET borrower =? ,dateBorrowed=?,dateDue=?, isReserved=? WHERE productID=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,Borrower);
            pstmt.setDate(2, Date.valueOf(DateBorrowed));
            pstmt.setDate(3, Date.valueOf(DateDue));
            pstmt.setBoolean(4,true);
            pstmt.setInt(5,getProductID());
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




    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


}
