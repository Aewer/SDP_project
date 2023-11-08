import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GUI {
    App app = new App();
    GUIFactory factory = new GUIFactory();
    StateContext stateContext = new StateContext();
    public static JTextField emailTextReg;
    public static JPasswordField passwordTextReg;
    public static JLabel registerSuccess;


    public static JTextField emailTextLog;
    public static JPasswordField passwordTextLog;
    public static JLabel loginSuccess;

    public GUI() throws SQLException {
    }

    public void registerGUI() throws SQLException {
        JFrame frameReg = factory.makeFrame("Register", 500, 200);
        JPanel panelReg = new JPanel();
        panelReg.setLayout(null);
        frameReg.add(panelReg);

        JLabel emailLabelReg = factory.makeLabel("Email", 10, 20, 80, 25);
        panelReg.add(emailLabelReg);

        emailTextReg = factory.makeTextField(20, 100, 20, 200, 25);
        panelReg.add(emailTextReg);

        JLabel passwordLabelReg = factory.makeLabel("Password", 10, 50, 80, 25);
        panelReg.add(passwordLabelReg);

        passwordTextReg = factory.makePasswordField(100, 50, 200, 25);
        panelReg.add(passwordTextReg);

        registerSuccess = factory.makeLabel("", 10, 110, 550, 25);
        panelReg.add(registerSuccess);

        JButton buttonRegister = new JButton("Register");
        buttonRegister.setBounds(10, 80, 100, 25);
        buttonRegister.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            app.registerSequence();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );
        panelReg.add(buttonRegister);

        JButton buttonGoToLogin = new JButton("Log into existing account");
        buttonGoToLogin.setBounds(10, 130, 200, 25);
        buttonGoToLogin.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frameReg.setVisible(false);
                        loginGUI();
                    }
                }
        );
        panelReg.add(buttonGoToLogin);


        frameReg.setVisible(true);
    }

    public void loginGUI() {
        JFrame frameLog = factory.makeFrame("Login", 500, 200);
        JPanel panelLog = new JPanel();
        panelLog.setLayout(null);
        frameLog.add(panelLog);

        JLabel emailLabelLog = factory.makeLabel("Email", 10, 20, 80, 25);
        panelLog.add(emailLabelLog);

        emailTextLog = factory.makeTextField(20, 100, 20, 200, 25);
        panelLog.add(emailTextLog);

        JLabel passwordLabelLog = factory.makeLabel("Password", 10, 50, 80, 25);
        panelLog.add(passwordLabelLog);

        passwordTextLog = factory.makePasswordField(100, 50, 200, 25);
        panelLog.add(passwordTextLog);

        loginSuccess = factory.makeLabel("", 10, 110, 300, 25);
        panelLog.add(loginSuccess);


        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(10, 80, 80, 25);
        buttonLogin.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            stateContext.login();
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );
        panelLog.add(buttonLogin);
        JButton buttonGoToRegister = new JButton("Register a new account");
        buttonGoToRegister.setBounds(10, 130, 200, 25);
        buttonGoToRegister.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frameLog.setVisible(false);
                        try {
                            registerGUI();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );
        panelLog.add(buttonGoToRegister);

        JButton buttonLogOut = new JButton("Log out");
        buttonLogOut.setBounds(100, 80, 80, 25);
        buttonLogOut.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        stateContext.logout();
                    }
                }
        );
        panelLog.add(buttonLogOut);

        frameLog.setVisible(true);

    }

}