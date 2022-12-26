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
    public void reserveOrReturn(LocalDate DateBorrowed, LocalDate DateDue) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Insert a new book into the Books table
            String sql = "UPDATE Book SET dateBorrowed=?,dateDue=?, isReserved=? WHERE productID=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            if(DateBorrowed==null){
                pstmt.setDate(1,null);}
            else{pstmt.setDate(1, Date.valueOf(DateBorrowed));
            }
            if(DateDue==null){
                pstmt.setDate(2,null);}
            else {
                pstmt.setDate(2, Date.valueOf(DateDue));
            }
            if(DateDue==null){
                pstmt.setBoolean(3,false);}
            else {
                pstmt.setBoolean(3, true);
            }

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




    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


}
