/*Nancy C Fain
*July 11, 2018
* Project 4
* Program to manage a student database.
* Utilize Hashmap with ID as primary key and student record is name and major
* Allow for input, delete, find, and update of records
* Display error windows
* Display student data
 */

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import static javax.swing.BoxLayout.*;
import static javax.swing.JOptionPane.*;

public class StudentGUI extends JFrame {

    private static final String STUDENT_MAJOR = "Enter the Student's Major";
    private static final String STUDENT_NAME = "Enter the Student's Name";
    private static final String STUDENT_ID = "Enter the Student's ID";
    private static final String PROCESS_REQUEST = "     Process Request    ";
    private static final String CHOOSE_SELECTION = "     Choose Selection";
    private static final String MAJOR = "     Major: ";
    private static final String NAME = "     Name:  ";
    private static final String ID = "     ID:  ";
    private static final String TEXT = "";

    private static final String INSERT = "Insert";
    private static final String DELETE = "Delete";
    private static final String FIND = "Find";
    private static final String UPDATE = "Update";

    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    private static final String D = "D";
    private static final String F = "F";
    private static final String CREDITA = "3";
    private static final String CREDITB = "6";

    private static final String SELECT_ACTION = "Select Action";
    private static final String SELECT_PROCESS = "Select to Process";
    private static final String RECORD_EXISTS = "Record Exists";
    private static final String RECORD = "Record ";
    private static final String SUCCESSFULLY_ADDED = "Successfully Added";
    private static final String SUCCESSFULLY_DELETED = "Successfully Deleted";
    private static final String RECORD_DOES_NOT_EXIST = "Record Does Not Exist";
    private static final String SELECT_GRADE = "Select Grade: ";
    private static final String GRADE = "Grade";
    private static final String NEED_VALID_ID = "Please Enter a Valid Student ID";
    private static final String SELECT_CREDITS = "Select Credits";
    private static final String CREDITS = "Credits";
    private static final String UPDATE_SUCCESSFUL = "Update Successful";
    private static final String PROJECT = "Project 4";


    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;


    /*Combo Box for Database Action Items*/

    private String[] grades = {A, B, C, D, F};
    private String[] credits = {CREDITA, CREDITB};

    private JComboBox<String> gradesList = new JComboBox<> ( grades );
    private JComboBox<String> creditList = new JComboBox<> ( credits );

    /*HashMap for DB values*/
    private HashMap<Integer, Student> hashMap = new HashMap<> ();


    private StudentGUI() {

        setLayout ( new GridLayout ( 1, 2 ) );

        /*Create Panels*/
        JPanel inputPanel = new JPanel ();
        inputPanel.setLayout ( new BoxLayout ( inputPanel, PAGE_AXIS ) );

        JPanel labelPanel = new JPanel ();
        labelPanel.setLayout ( new BoxLayout ( labelPanel, PAGE_AXIS ) );

        JPanel gradePanel = new JPanel ();
        gradePanel.setLayout ( new BoxLayout ( gradePanel, PAGE_AXIS ) );

        JPanel creditPanel = new JPanel ();
        creditPanel.setLayout ( new BoxLayout ( creditPanel, PAGE_AXIS ) );

        inputPanel.add ( Box.createVerticalStrut ( 10 ) );
        labelPanel.add ( Box.createVerticalStrut ( 25 ) );
        JLabel idLabel = new JLabel ( ID );
        labelPanel.add ( idLabel );

        labelPanel.add ( Box.createVerticalStrut ( 30 ) );
        JLabel nameLabel = new JLabel ( NAME );
        labelPanel.add ( nameLabel );

        labelPanel.add ( Box.createVerticalStrut ( 30 ) );
        JLabel majorLabel = new JLabel ( MAJOR );
        labelPanel.add ( majorLabel );


        labelPanel.add ( Box.createVerticalStrut ( 30 ) );
        JLabel chooseSelection = new JLabel ( CHOOSE_SELECTION );
        labelPanel.add ( chooseSelection );

        labelPanel.add ( Box.createVerticalStrut ( 30 ) );
        JButton processRequestButton = new JButton ( PROCESS_REQUEST );
        labelPanel.add ( processRequestButton );
        labelPanel.add ( Box.createVerticalStrut ( 25 ) );


        JTextField id = new JTextField ( TEXT );
        inputPanel.add ( id );
        inputPanel.add ( Box.createVerticalStrut ( 10 ) );

        JTextField name = new JTextField ( TEXT );
        inputPanel.add ( name );
        inputPanel.add ( Box.createVerticalStrut ( 10 ) );

        JTextField major = new JTextField ( TEXT );
        inputPanel.add ( major );
        inputPanel.add ( Box.createVerticalStrut ( 10 ) );

        String[] actions = {INSERT, DELETE, FIND, UPDATE};
        JComboBox<String> actionList = new JComboBox<> ( actions );
        inputPanel.add ( actionList );
        inputPanel.add ( Box.createVerticalStrut ( 70 ) );
        actionList.setSelectedIndex ( 0 );

        add ( labelPanel );
        add ( inputPanel );

        id.setEditable ( true );
        name.setEditable ( true );
        major.setEditable ( true );

        /*create tooltips to prompt for information*/

        id.setToolTipText ( STUDENT_ID );
        name.setToolTipText ( STUDENT_NAME );
        major.setToolTipText ( STUDENT_MAJOR );
        actionList.setToolTipText ( SELECT_ACTION );
        processRequestButton.setToolTipText ( SELECT_PROCESS );

        /*create listeners*/
        processRequestButton.addActionListener( e -> {

        try {
            int studentID = Integer.parseInt ( id.getText () );

            if (!(studentID > 1))
                throw new NumberFormatException ();

            /* Create Student*/

            if (actionList.getSelectedIndex () == 0) {
                if (hashMap.containsKey ( studentID )) {
                    showMessageDialog ( null, RECORD_EXISTS );
                } else {
                    Student student = new Student ( name.getText (), major.getText () );
                    hashMap.put ( studentID, student );
                    showMessageDialog ( null, RECORD + SUCCESSFULLY_ADDED );
                }

                /*Delete Student*/
            } else if (1 == actionList.getSelectedIndex ()) {
                if (hashMap.containsKey ( studentID )) {
                    hashMap.remove ( studentID );
                    showMessageDialog ( null, RECORD + SUCCESSFULLY_DELETED );

                } else {
                    showMessageDialog ( null, RECORD_DOES_NOT_EXIST );
                }

                /*Find Student*/
            } else if (actionList.getSelectedIndex () == 2) {
                if (hashMap.containsKey ( studentID )) {
                    showMessageDialog ( null, hashMap.get ( studentID ).toString () );

                } else {
                    showMessageDialog ( null, RECORD_DOES_NOT_EXIST );
                }
                /*Update Student*/
            } else if (actionList.getSelectedIndex () == 3) {
                String[] gradeList = {A, B, C, D, F};
                String[] creditList = {CREDITA, CREDITB};

                float grade;
                int credits;

                /*Input for Grades*/
                if (hashMap.containsKey ( studentID )) {
                    String gradeValue = (String) showInputDialog ( null, SELECT_GRADE,
                            GRADE, QUESTION_MESSAGE, null, gradeList, gradeList[0] );

                    /*Input for Number of Credits for the Course*/

                    String creditValue = (String) showInputDialog ( null, SELECT_CREDITS,
                            CREDITS, QUESTION_MESSAGE, null, creditList, creditList[0] );
                    credits = Integer.parseInt(creditValue);


                    /*Letter Grades*/
                    switch (gradeValue) {
                        case A:
                            grade = 4;
                            break;
                        case B:
                            grade = 3;
                            break;
                        case C:
                            grade = 2;
                            break;
                        case D:
                            grade = 1;
                            break;
                        default:
                            grade = 0;
                            break;
                    }

                    Student student = hashMap.get ( studentID );
                    student.courseCompleted ( grade, credits );
                    showMessageDialog ( null, RECORD + UPDATE_SUCCESSFUL );

                } else {
                    showMessageDialog ( null, RECORD_DOES_NOT_EXIST );
                }

            } else {
                System.exit ( 0 );
            }

        } catch (NumberFormatException nfe) {
            showMessageDialog ( null, NEED_VALID_ID );
        }
    } ); /*end listener*/
    }/*end panel*/


   public static void main(String[] args) {
        StudentGUI student = new StudentGUI ();
        student.setTitle ( PROJECT);
        student.setSize ( WIDTH, HEIGHT );
        student.setLocationRelativeTo ( null );
        student.setDefaultCloseOperation ( WindowConstants.EXIT_ON_CLOSE );
        student.setResizable ( false );
        student.setVisible ( true );

    }

}
