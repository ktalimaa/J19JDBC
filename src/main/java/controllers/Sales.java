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
}
