public class LoggedInState implements State {
    @Override
    public void handleLogin() {
        GUI.loginSuccess.setText("Already logged in.");
    }

    @Override
    public void handleLogout() {
        StateContext.setState(new LoggedOutState());
        GUI.loginSuccess.setText("Logged out successfully");
    }
}