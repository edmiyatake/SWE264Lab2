import java.util.Observable;
import java.util.Observer;

public class OverbookedCourseMonitor implements Observer {

    // Max capacity for all courses
    private static final int MAX_CAPACITY = 3;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("OverBookingComponent notified.");
        if (o instanceof Course) {
            Course course = (Course) o;

            // Check if the course is overbooked
            if (course.getRegisteredStudents().size() > MAX_CAPACITY) {
                System.out.println("Warning: Course " + course.getName() + " is overbooked!");
            }
        }
    }
}
