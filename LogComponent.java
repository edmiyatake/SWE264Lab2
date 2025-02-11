import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogComponent {
    private static final String LOG_FILE = "system.log"; // Log file name
    private static PrintWriter writer;

    // Initialize the logger
    static {
        try {
            writer = new PrintWriter(new FileWriter(LOG_FILE, true), true); // Append mode
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }

    // Method to log messages
    public static void log(String message) {
        System.out.println(message); // Print to console
        if (writer != null) {
            writer.println(message); // Write to log file
        }
    }

    // Close the logger when the program ends
    public static void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
