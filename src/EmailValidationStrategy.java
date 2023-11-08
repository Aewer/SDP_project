import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailValidationStrategy implements ValidationStrategy {
    public boolean validate(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            GUI.registerSuccess.setText("Invalid Email");
            result = false;
        }
        return result;
    }
}
