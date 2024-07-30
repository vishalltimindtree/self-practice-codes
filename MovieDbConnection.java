import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MovieDbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/MoviesDB";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }
}
