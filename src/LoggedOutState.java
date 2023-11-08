import java.sql.SQLException;

public class LoggedOutState implements State {
    @Override
    public void handleLogin() throws SQLException {
        Login login = new Login();
        login.setUsername(GUI.emailTextLog.getText());
        login.setPassword(GUI.passwordTextLog.getText());
        login.login();
        StateContext.setState(new LoggedInState());
    }

    @Override
    public void handleLogout() {
        GUI.loginSuccess.setText("Already logged out.");
    }
}