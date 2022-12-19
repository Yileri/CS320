import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDB {
//        Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306", "1JMibyaVTO", "6hX7WHl7uj");
//    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://remotemysql.com:3306";
    private static final String USERNAME = "1JMibyaVTO";
    private static final String PASSWORD = "6hX7WHl7uj";

    @Test
    public void testJdbcConnection() {
        Connection conn = null;
        try {
            // Register the JDBC driver
//            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch ( SQLException e) {
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
}