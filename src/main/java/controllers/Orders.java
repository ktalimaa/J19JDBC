package controllers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Orders {
    static Connection connection = Database.DbConn();
    static PreparedStatement ps;
    static ResultSet rs;
    static Scanner scanner = new Scanner(System.in);

    public static boolean createOrdersTable() {
        try {
            ps = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS orders(" +
                            "sale_id int NOT NULL," +
                            "item_id int NOT NULL," +
                            "qty_purchased int NOT NULL," +
                            "item_total int NOT NULL, " +
                            "FOREIGN KEY(sale_id) REFERENCES sales(id), " +
                            "FOREIGN KEY(item_id) REFERENCES items(id))");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void getAllOrders() {

        try {
            ps = connection.prepareStatement("SELECT * FROM orders");
            rs = ps.executeQuery();

            while (rs.next()) {
                int saleId = Integer.parseInt("sale_id: " + rs.getInt("sale_id"));
                int itemId = Integer.parseInt("item_id: " + rs.getString("item_id"));
                int qtyPurchased = Integer.parseInt("qty_purchased: " + rs.getString("qty_purchased"));
                int itemTotal = Integer.parseInt("item_total: " + rs.getInt("item_total"));
                System.out.println(saleId + ", " + itemId + ", " + qtyPurchased + ", " + itemTotal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
