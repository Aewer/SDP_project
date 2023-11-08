import java.sql.SQLException;

public interface State {
    void handleLogin() throws SQLException;
    void handleLogout();
}
