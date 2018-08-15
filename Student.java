/*Nancy C Fain
 *July 11, 2018
 * Project 4
 * Program to manage a student database.
 * Utilize Hashmap with ID as primary key and student record is name and major
 * Allow for input, delete, find, and update of records
 * Display error windows
 * Display student data
 */

public class Student {


    /* Variables*/
    private String studentName;
    private String studentMajor;
    private int totalCredits;
    private float qualityPoints;

    /* Constructors*/
    Student(String studentName, String studentMajor) {
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        this.totalCredits = 0;
        this.qualityPoints= 0;
    }

    /*method for updating values for GPA computation*/

    public void courseCompleted (float grade, int credits){
        qualityPoints += (grade * credits);
        totalCredits += credits;

    }
    /*To String Method*/

    public String toString() {
        if (totalCredits == 0){
            return String.format ( "Name: %s\nMajor: %s\nGPA: 4.0", studentName, studentMajor );
         } else {
        return String.format ( "Name: %s\nMajor: %s\nGPA: %s", studentName, studentMajor,
                String.format ( "%.2g%n", (qualityPoints / totalCredits) ) );
        }
    }
}
