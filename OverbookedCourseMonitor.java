import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class OverbookedCourseMonitor implements Observer {
    private static final int OVERBOOKED_THRESHOLD = 3; // Max 3 students before overbooked
    private Map<String, Integer> courseRegistrations; // Course ID -> Number of students

    public OverbookedCourseMonitor() {
        this.courseRegistrations = new HashMap<>();
        EventBus.subscribeTo(EventBus.EV_REGISTER_STUDENT, this); // Listen for registrations
    }

    @Override
    public void update(Observable event, Object message) {
        if (message instanceof String) {
            String courseID = (String) message;
            courseRegistrations.put(courseID, courseRegistrations.getOrDefault(courseID, 0) + 1);

            if (courseRegistrations.get(courseID) > OVERBOOKED_THRESHOLD) {
                EventBus.announce(EventBus.EV_COURSE_OVERBOOKED, 
                    "Warning: Course " + courseID + " is overbooked!");
            }
        }
    }
}
