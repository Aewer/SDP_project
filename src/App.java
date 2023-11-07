import java.sql.*;

public class App {
    public App() throws SQLException {
    }
    Register register = new Register();
    Login login = new Login();
    public void registerSequence() throws SQLException {
        register.setUsername(GUI.emailTextReg.getText());
        register.setPassword(GUI.passwordTextReg.getText().toCharArray());
        if (register.checkEmail()) {
            if (register.checkPassword()) {
                register.registerToDatabase();
            }
        }
    }
    public void loginSequence() throws SQLException {
        login.setUsername(GUI.emailTextLog.getText());
        login.setPassword(GUI.passwordTextLog.getText());
        login.login();
    }
}