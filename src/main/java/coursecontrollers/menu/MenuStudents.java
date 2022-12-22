package coursecontrollers.menu;

import coursecontrollers.Students;

import java.util.Scanner;

public class MenuStudents {

    static Scanner scanner = new Scanner(System.in);

    public static void mainMenuForCourse() {
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Students");
        System.out.println("2. Grades");
        // System.out.println("2. Grades");

        System.out.println("-----------------");
        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                studentMenu();
                break;
            case 2:
                gradesMenu();
                break;
            default:
                System.out.println("Invalid option!");
                mainMenuForCourse();
                break;
        }
    }

    public static void studentMenu() {
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Get All Students");
        System.out.println("2. Add a New Student");

        System.out.println("-----------------");
        System.out.println("Select an option or enter 0 to go back to main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenuForCourse();
                break;
            case 1:
                Students.getAllStudents();
                studentMenu();
                break;
            case 2:
                Students.createNewStudent();
                studentMenu();
                break;
            default:
                System.out.println("Invalid option!");
                studentMenu();
                break;
        }
    }

    public static void gradesMenu() {
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Get All Grades");

        System.out.println("-----------------");
        System.out.println("Select an option or enter 0 to go back to main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenuForCourse();
                break;
            // case 1:
            // Grades.getAllGrades();
            // gradesMenu();
            // break;
            default:
                System.out.println("Invalid option!");
                studentMenu();
                break;
        }
    }


}
