import java.util.ArrayList;

public class CourseConflictChecker {
    /**
     * Checks if the given course conflicts with any of the courses the student has already registered.
     *
     * @param objStudent The student attempting to register.
     * @param objCourse  The course the student is trying to register for.
     * @return `true` if there is a conflict, `false` otherwise.
     */
    public static boolean hasConflict(Student objStudent, Course objCourse) {
        ArrayList<Course> registeredCourses = objStudent.getRegisteredCourses();

        for (Course registeredCourse : registeredCourses) {
            if (registeredCourse.conflicts(objCourse)) {
                return true;
            }
        }

        return false;
    }
}