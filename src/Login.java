import java.sql.*;

public class Login {

    public Login() throws SQLException {
    }
    private String username;
    private String password;
    private int att = 3;
    DbConnection dbConnection = DbConnection.getInstance();
    Publisher publisher = new Publisher();


    public void login() throws SQLException {
        publisher.addObserver(new ConsoleLogListener());
        publisher.addObserver(new FileLogListener("log.txt"));

        String encryptedPassword = Encryption.encrypt(password);

        try (Connection connection = dbConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from auth");
            boolean flag = false;
            while (resultSet.next()) {
                String tempUsername = resultSet.getString(1);
                String tempPassword = resultSet.getString(2);
                if (encryptedPassword != null && username.equals(tempUsername) && encryptedPassword.equals(tempPassword)) {
                    GUI.loginSuccess.setText("Authentication successful!");
                    publisher.log("Authentication successful. Username: " + username);
                    flag = true;
                    break;
                }
            }
            if (!flag && att == 0) {
                GUI.loginSuccess.setText("0 Attempts left. Blocked.");
                publisher.log("0 Attempts left. Blocked. Username: " + username);
                System.exit(0);
            } else if (!flag) {
                GUI.loginSuccess.setText("Invalid login or password, try again. Attempts left: " + att);
                publisher.log("Invalid login or password. Attempts left: " + att + " Username: " + username);
                att--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}