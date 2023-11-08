import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class Register {
    private String username;
    private char[] password;
    //private boolean check1 = false, check2 = false, check3 = false;
    DbConnection dbConnection = DbConnection.getInstance();
    public Register() throws SQLException {
    }
    /*public boolean checkEmail() {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(username);
            emailAddr.validate();
        } catch (AddressException ex) {
            GUI.registerSuccess.setText("Invalid Email");
            result = false;
        }
        return result;
    }*/

    /*public boolean checkPassword() {
        if (password.length > 6) {
            for (int k = 0; k < password.length; k++) {
                if (password[k] >= 48 && password[k] <= 57) {
                    check1 = true;
                } else if (password[k] >= 65 && password[k] <= 90) {
                    check2 = true;
                } else if (password[k] >= 97 && password[k] <= 122) {
                    check3 = true;
                }
            }
            if ((check1) && (check2) && (check3)) {
                GUI.registerSuccess.setText("Registration successful");
                return true;
            } else {
                GUI.registerSuccess.setText("Your password must include at least one capital letter, lower letter and digit.");
                return false;
            }
        } else {
            GUI.registerSuccess.setText("Registration error. Your password must be longer than 6 symbols.");
            return false;
        }
    }*/

    public void registerToDatabase() throws SQLException {
        String passwordString = new String(password);
        String encryptedPassword = Encryption.encrypt(passwordString);
        String sql = "insert into auth (username, password) values (?, ?)";
        try (Connection connection = dbConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, encryptedPassword);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public char[] getPassword() {
        return password;
    }
}