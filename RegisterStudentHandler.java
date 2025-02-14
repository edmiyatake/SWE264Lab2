/**
 * @(#)RegisterStudentHandler.java
 *
 * Copyright: Copyright (c) 2003,2004 Carnegie Mellon University
 *
 */

import java.util.StringTokenizer;


/**
 * "Register a student for a course" command event handler.
 */
public class RegisterStudentHandler extends CommandEventHandler {
    private static boolean isProcessing = false;  // Static flag to prevent recursion

    /**
     * Construct "Register a student for a course" command event handler.
     *
     * @param objDataBase reference to the database object
     * @param iCommandEvCode command event code to receive the commands to process
     * @param iOutputEvCode output event code to send the command processing result
     */
    public RegisterStudentHandler(DataBase objDataBase, int iCommandEvCode, int iOutputEvCode) {
        super(objDataBase, iCommandEvCode, iOutputEvCode);
    }

    /**
     * Process "Register a student for a course" command event.
     *
     * @param param a string parameter for command
     * @return a string result of command processing
     */
    protected String execute(String param) {
        if (isProcessing) {
            return "Already processing the registration. Please wait...";
        }

        isProcessing = true;

        // Parse the parameters.
        StringTokenizer objTokenizer = new StringTokenizer(param);
        String sSID     = objTokenizer.nextToken();
        String sCID     = objTokenizer.nextToken();
        String sSection = objTokenizer.nextToken();

        // Get the student and course records.
        Student objStudent = this.objDataBase.getStudentRecord(sSID);
        Course objCourse = this.objDataBase.getCourseRecord(sCID, sSection);
        
        if (objStudent == null) {
            isProcessing = false;
            return "Invalid student ID";
        }
        if (objCourse == null) {
            isProcessing = false;
            return "Invalid course ID or course section";
        }

        // Check if the given course conflicts with any of the courses the student has registered.
        // replaced with new component
        if (CourseConflictChecker.hasConflict(objStudent, objCourse)) {
            isProcessing = false;  // Reset flag before returning
            return "Registration conflicts";
        }

        // Request validated. Proceed to register.
        this.objDataBase.makeARegistration(sSID, sCID, sSection);

        // Reset the flag after processing the registration
        isProcessing = false;

        return "Successful!";
    }
}