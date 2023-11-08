public class Validator {
    private ValidationStrategy validationStrategy;
    public void setValidationStrategy(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }
    public boolean validate(String data) {
        return validationStrategy.validate(data);
    }
}
