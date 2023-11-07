public class ConsoleLogListener implements LogListener {
    @Override
    public void update(String message) {
        System.out.println("Console Log: " + message);
    }
}