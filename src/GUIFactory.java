import javax.swing.*;
public class GUIFactory {
    public JFrame makeFrame(String name, int width, int height) {
        JFrame newFrame = new JFrame(name);
        JPanel newPanel = new JPanel();
        newFrame.setSize(width, height);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.add(newPanel);

        newPanel.setLayout(null);
        return newFrame;
    }

    public JLabel makeLabel(String text, int x, int y, int width, int height) {
        JLabel newLabel = new JLabel(text);
        newLabel.setBounds(x, y, width, height);
        return newLabel;
    }

    public JTextField makeTextField(int length, int x, int y, int width, int height) {
        JTextField newTextField = new JTextField(length);
        newTextField.setBounds(x, y, width, height);
        return newTextField;
    }

    public JPasswordField makePasswordField(int x, int y, int width, int height) {
        JPasswordField newPasswordField = new JPasswordField();
        newPasswordField.setBounds(x, y, width, height);
        return newPasswordField;
    }
}
