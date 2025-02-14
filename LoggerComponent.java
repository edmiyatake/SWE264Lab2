import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

public class LoggerComponent implements Observer {
    private static final String LOG_FILE = "system.log";

    public LoggerComponent() {
        // Subscribe to EV_SHOW event
        EventBus.subscribeTo(EventBus.EV_SHOW, this);
    }

    @Override
    public void update(Observable event, Object message) {
        if (message instanceof String) {
            logToFile((String) message);
        }
    }

    private void logToFile(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println(message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}