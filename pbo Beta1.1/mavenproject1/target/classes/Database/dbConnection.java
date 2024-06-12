package Database;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static Connection con;

    public static Connection getConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3307/storehub";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new Driver());
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return con;
    }
}
