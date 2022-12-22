package coursecontrollers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Grades {

    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static void createGradesTable() {
        try {
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS students(" +
                    "    id serial PRIMARY KEY," +
                    "    student_id int," +
                    "    score int NOT NULL," +
                    "    grade varchar(50) NOT NULL," +
                    "    FOREIGN KEY (student_id) REFERENCES students(id))");
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
