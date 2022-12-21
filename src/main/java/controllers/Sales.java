package controllers;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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

    // CREATE a method on the Sales class that takes in following input from the user:
    // item_id
    // qty_purchased

    // we need loop, what says how many items we want to buy
    // if we get this qty info, it goes to total
    // orders are the part of the sale.

    public static Map<Integer, Float> handleItemTotal() {
        // Prompt
        System.out.println("Enter how many items were bought: ");
        int numberOfItems = scanner.nextInt();

        // Map will hold the values of item_id and qty_purchased
        Map<Integer, Float> items = new HashMap<>();
        float itemTotal = 0;
        // We want to store each values

        for (int i = 0; i < numberOfItems; i++) {
            // first we need to reach into items table, price
            // Use the connection to get the by the id (SELECT) after you pass it into the map
            System.out.print("Enter the item id: ");
            int itemId = scanner.nextInt();

            System.out.println("Enter the quantity purchased: ");
            int qty = scanner.nextInt();

            // loop into items table and find out the price of the item

            float itemPrice = 0;

            try {
                ps = connection.prepareStatement("SELECT price FROM items WHERE id = " + itemId);
                rs = ps.executeQuery();

                while (rs.next()) {
                    itemPrice = rs.getFloat("price");
                }
                itemTotal = itemPrice * qty;
                items.putIfAbsent(itemId, itemTotal);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //  System.out.println(items);
        return items;
    }

    // Exercise: Complete Sales class by adding following methods:
    // Add a method called createNewSale:       (it has id, customer id, date prc, total?)
    // - collate the total price of all the items bought using the handleItemsTotal method
    // and log the total to the console.


    // call handleItemsTotal()  in the createNewSale()
    // use this map to collate
    // instead storing itemId, we store saleId

    // public static Map<Integer, Float> exercise() {
    // call this same method to complete this transaction. loop through the hashmap
    // return (items);

    public static void createNewSale() {
        System.out.println("Possible items are: 2, 3, 4, 5.");
        System.out.println("Enter the item id what you would like to buy: ");

        System.out.println("Enter the quantity of the product you would like to buy: ");
        int qty = scanner.nextInt();

        System.out.println();


    }

}
