public class PasswordValidationStrategy implements ValidationStrategy {
    public boolean validate(String passwordString) {
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasLowercase = false;

        if (passwordString.length() > 6) {
            for (char c : passwordString.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                } else if (Character.isLowerCase(c)) {
                    hasLowercase = true;
                }
            }

            if (hasDigit && hasUppercase && hasLowercase) {
                GUI.registerSuccess.setText("Registration successful");
                return true;
            } else {
                GUI.registerSuccess.setText("Your password must include at least one capital letter, lower letter, and digit.");
                return false;
            }
        } else {
            GUI.registerSuccess.setText("Registration error. Your password must be longer than 6 symbols.");
            return false;
        }
    }
}
