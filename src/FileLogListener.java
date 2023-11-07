import java.io.FileWriter;
import java.io.IOException;

public class FileLogListener implements LogListener {
    private String logFileName;

    public FileLogListener(String logFileName) {
        this.logFileName = logFileName;
    }

    @Override
    public void update(String message) {
        try (FileWriter fileWriter = new FileWriter(logFileName, true)) {
            fileWriter.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}