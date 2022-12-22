package coursecontrollers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Students {

    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static void createStudentsTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS students(" +
                    "    id serial PRIMARY KEY," +
                    "    name varchar(255) NOT NULL," +
                    "    age int NOT NULL)");
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void getAllStudents() {

        try {
            ps = connection.prepareStatement("SELECT * FROM students");
            rs = ps.executeQuery();

            // now we loop through the result set
            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String name = "name: " + rs.getString("name");
                String age = "age: " + rs.getInt("age");
                System.out.println(id + " " + name + " " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static boolean createNewStudent() {
        // Add prompts to tell the user what data they need to enter next
        System.out.println("Enter the students name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the students age: ");
        String age = scanner.nextLine();

        try {

            ps = connection.prepareStatement("INSERT INTO students(name, age)" +
                    "VALUES('" + name + "', " + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public static void deleteStudent() {
        System.out.println("Enter the id of the student you want to delete: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FROM students WHERE id = " + id);
            ps.execute();

            ps = connection.prepareStatement("DELETE FROM grades WHERE id = " + id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
