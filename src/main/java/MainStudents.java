import coursecontrollers.menu.MenuStudents;

public class MainStudents {

    // Create a table that called Students and another table called Grades
    // The fields/columns on the student table should be as follows: id, name, age
    // create obj of studs or table of courses.
    // Complete the controllers for the students table by adding methods to handle CRD operations on each record in the table.

    // On the Grades table, store the student's id, score and the Grade where for each Grade:
    // The columns on Grades should be: id, student_id, score, grade.
    // 0 - 40 = F, 41 - 49 = D, 50 - 59 = C, 60 - 69 = B, 70 - 100 = A
    // Complete the controller for the Grades table to have Create, Read and Delete operations.
    // For read operation, you should be able to see the students information as well.

    // when score is entered, compare it e.g. is it between 0-40, etc. and then it gives grade
    // ask user for the score, not the grade
    // checks the score
    // method to check the score is it between the range, e.g. if else

    public static void main(String[] args) {

        // Students.createStudentsTable();
        // Grades.createGradesTable();

        MenuStudents.mainMenuForCourse();

    }
}
