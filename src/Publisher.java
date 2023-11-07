import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<LogListener> listeners = new ArrayList<>();

    public void log(String message) {
        notifyListeners(message);
    }

    public void addObserver(LogListener listener) {
        listeners.add(listener);
    }

    public void removeObserver(LogListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(String message) {
        for (LogListener listener : listeners) {
            listener.update(message);
        }
    }
}