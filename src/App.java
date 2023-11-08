import java.sql.*;
import java.util.Arrays;

public class App {
    Validator validator = new Validator();
    public App() throws SQLException {
    }
    Register register = new Register();
    public void registerSequence() throws SQLException {
        register.setUsername(GUI.emailTextReg.getText());
        register.setPassword(GUI.passwordTextReg.getText().toCharArray());
        validator.setValidationStrategy(new EmailValidationStrategy());
        if (validator.validate(register.getUsername())) {
            validator.setValidationStrategy(new PasswordValidationStrategy());
            if (validator.validate(Arrays.toString(register.getPassword()))) {
                register.registerToDatabase();
            }
        }
    }
}