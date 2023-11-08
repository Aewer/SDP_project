import java.sql.SQLException;

public class StateContext {
    private static State currentState;

    public StateContext() {
        currentState = new LoggedOutState();
    }

    public static void setState(State state) {
        currentState = state;
    }

    public void login() throws SQLException {
        currentState.handleLogin();
    }

    public void logout() {
        currentState.handleLogout();
    }
}