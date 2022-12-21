package controllers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Sales {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static boolean createSalesTable() {
        try {
            ps = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS sales(" +
                            "id serial PRIMARY KEY, " +
                            "customer_id int, " +
                            "date_purchased TIMESTAMP, " +
                            "total float, " +
                            "FOREIGN KEY (customer_id) REFERENCES customer(id))");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void getAllSales() {

        try {
            ps = connection.prepareStatement("SELECT * FROM sales");
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                int customerId = Integer.parseInt("customer_id: " + rs.getString("customer_id"));
                int timestamp = Integer.parseInt("timestamp: " + rs.getString("timestamp"));
                float total = Integer.parseInt("total: " + rs.getInt("total"));
                System.out.println(id + ", " + customerId + ", " + timestamp + ", " + total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /*

    public static boolean createNewSale() {
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

    public static boolean updateSale() {
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
            updateSale();
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

    public static void deleteSale() {
        System.out.println("Enter the id of the customer to delete: ");
        int id = scanner.nextInt();

        try {
            ps = connection.prepareStatement("DELETE FORM sales WHERE customer_id = " + id);
            ps.execute();

            ps = connection.prepareStatement("DELETE FROM customer WHERE id = " + id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    */


}
