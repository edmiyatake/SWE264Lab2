import java.util.HashMap;
import java.util.Map;

public class OverBookingComponent {
    private static final int MAX_CAPACITY = 3;
    private static final Map<String, Integer> courseRegistrations = new HashMap<>(); // each course needs a student count

    // Method to track registrations
    public static void registerStudent(String courseId, String section) {
        String key = courseId + "-" + section; // Unique key for each course-section

        // Increase student count
        courseRegistrations.put(key, courseRegistrations.getOrDefault(key, 0) + 1);

        // Check if the course is overbooked
        if (courseRegistrations.get(key) > MAX_CAPACITY) {
            LogComponent.log("⚠ WARNING: Course " + courseId + " Section " + section + " is OVERBOOKED!");
        }
    }

    // Method to reset data (if needed for testing)
    public static void reset() {
        courseRegistrations.clear();
    }
}
