# IMProgram4
Student Database
This programming project involves writing a program to manage a student database. The interface to
the program should be a GUI that looks similar to the following:
A combo box should allow the user to select one of the four database actions shown. The database
should be implemented as a HashMap, with the ID field as the key and a student record consisting of a
name and major as the value. The operation should be performed when the user clicks the Process
Request button. If the user attempts to insert a key that is already in the database an error message
should be displayed using a JOptionPane message dialog box. If the user attempts to delete, find or
update a record that is not in the database, a message should also be displayed. After each successful
operation is completed a JOptionPane window should be displayed confirming the success. In the case
of a successful Find request, a window should pop up containing the student's ID, name, major and
current GPA. When the user selects the Update request, the following JOptionPane windows should be
displayed to gather information about a course that has just been completed:
2
This program must consist of two classes.
1. The first class should define the GUI and handle the database interactions.
2. The second class named Student, should define the student record. It must have instance
variables for the student name, major and two variables that are used to compute the GPA. A
variable that contains the total number of credits completed and a second variable that contains
the total quality points, which are the numeric value of the grade received in a course times the
number of credit hours. It should not contain the student ID. The class should have the following
three methods:
a. A constructor that is used when new student records are created. It should accept the name
and major as parameters and initialize the fields that are used to compute the GPA to zero.
b. The second method courseCompleted should accept the course grade and credit hours and
update the variables used to compute the GPA. It will be called when an Update request is
made.
c. The third method should override toString and return a labeled string containing the
student name, major and GPA.
Finally when a student has not yet completed any course, the GPA should be displayed as 4.0.
