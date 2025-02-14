import java.util.ArrayList;

/**
 * CourseConflictChecker checks for conflicts between a student's existing course registrations and
 * a new course they wish to register for.
 */
public class CourseConflictChecker {

    /**
     * Checks if the student has any conflicts with the given course.
     *
     * @param objStudent The student object that is being checked for conflicts.
     * @param objCourse  The course that the student is trying to register for.
     * @return true if there is a conflict, false otherwise.
     */
    public static boolean hasConflict(Student objStudent, Course objCourse) {
        // Get the list of courses that the student is already registered for
        ArrayList<Course> registeredCourses = objStudent.getRegisteredCourses();

        // Check each of the student's currently registered courses for a time conflict
        for (Course registeredCourse : registeredCourses) {
            // If the courses have any conflict (using the `conflicts` method), return true
            if (registeredCourse.conflicts(objCourse)) {
                return true;
            }
        }
        
        // If no conflict is found, return false
        return false;
    }
}
