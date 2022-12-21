package controllers;

import db.Database;
import org.postgresql.util.OSUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {

    static Connection connection = Database.DbConn();       // same fields as in Item class
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    // CRUD - CREATE, READ, UPDATE, DELETE


    // Create a table dor the class above if and only if it doesn't already exist.
    public static boolean createCustomerTable() {
        try {       // "IF NOT EXISTS" only then create table!
            ps = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS customer(" +
                            "id serial," +
                            "first_name varchar(255)," +
                            "last_name varchar(255), " +
                            "email varchar(255), " +
                            "PRIMARY KEY(id))");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ
    public static void getAllCustomers() {

        try {
            ps = connection.prepareStatement("SELECT * FROM customer");
            rs = ps.executeQuery();     // prepareStatement will write sql in

            // now we loop through the result set
            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String firstName = "first_name: " + rs.getString("first_name");
                String lastName = "last_name: " + rs.getString("last_name");
                String email = "email: " + rs.getString("email");
                System.out.println(id + ", " + firstName + ", " + lastName + ", " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Complete the Customer class by adding the CREATE, UPDATE and DELETE functionalities
    // to handle those respective operations on a customer objects or record.

    public static boolean createNewCustomer() {
        // Add prompts to tell the user what data they need to enter next
        System.out.println("Enter the customer first name: ");
        String fName = scanner.nextLine();

        System.out.println("Enter the customer last name: ");
        String lName = scanner.nextLine();

        System.out.println("Enter the customer email: ");
        String email = scanner.nextLine();

        try {

            ps = connection.prepareStatement("INSERT INTO customer(first_name, last_name, email)" +
                    "VALUES('" + fName + "', '" + lName + "', '" + email + "')");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateCustomer() {
        // Prompt the user for info
        System.out.println("Possible fields to update: first_name, last_name, email");

        System.out.print("Enter the field name you would like to update: ");
        String fieldName = scanner.nextLine();

        System.out.println("Enter the value for the field: ");
        String fieldValue = scanner.nextLine();

        System.out.println("Enter the customers id: ");
        int id = scanner.nextInt();

        if (!fieldName.equals("first_name") || !fieldName.equals("last_name") || !fieldName.equals("email")) {
            System.out.println("Invalid field name!");
            updateCustomer();
        }

        try {
            ps = connection.prepareStatement("UPDATE customer SET " +
                    fieldName + " = '" + fieldValue + "', " + "WHERE id = " + id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void deleteCustomer() {
        System.out.println("Enter the id of the customer to delete: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FROM sales WHERE customer_id = " + id);
            ps.execute();

            ps = connection.prepareStatement("DELETE FROM customer WHERE id = " + id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
