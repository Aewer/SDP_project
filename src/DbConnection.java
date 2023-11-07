import java.sql.*;
public class DbConnection {

    private static DbConnection dbInstance;
    private static Connection con;


    private DbConnection() {
    }

    public static DbConnection getInstance() {
        if (dbInstance == null) {
            dbInstance = new DbConnection();
        }
        return dbInstance;
    }

    public Connection getConnection() throws SQLException {

        if (con == null || con.isClosed()) {
            try {
                String host = "jdbc:postgresql://localhost:5432/postgres";
                String username = "postgres";
                String password = "slawa111111";
                con = DriverManager.getConnection(host, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return con;
    }
}