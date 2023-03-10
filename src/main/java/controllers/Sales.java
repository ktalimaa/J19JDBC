package controllers;

import db.Database;
import objects.OrderObj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
            ps = connection.prepareStatement("SELECT sales.*, customer.first_name, customer.last_name FROM sales LEFT JOIN customer ON sales.customer_id = customer.id");
            rs = ps.executeQuery();

            // Loop through the result set
            while (rs.next()) {
                String id = "id: " + rs.getInt("id");
                String custId = "customer_id: " + rs.getInt("customer_id");
                String datePurchased = "date_purchased: " + rs.getTimestamp("date_purchased");
                String total = "total: " + rs.getFloat("total");
                String firstName = "fist_name: " + rs.getString("first_name");
                String lastName = "last_name: " + rs.getString("last_name");
                System.out.println(id + ", " + custId + ", " + total + ", " + firstName + ", " + lastName + ", " + datePurchased);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CREATE a method on the Sale class that takes in following input from the user:
    // item_id
    // qty_purchased

    // we need loop, what says how many items we want to buy
    // if we get this qty info, it goes to total
    // orders are the part of the sale.

    private static List<OrderObj> handleItemTotal() {
        // Prompt
        System.out.println("Enter how many items were bought: ");
        int numberOfItems = scanner.nextInt();

        // Map will hold the values of item_id and qty_purchased
        // Map<Integer, Float> items = new HashMap<>();
        List<OrderObj> itemsPurchased = new ArrayList<>();
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
                //items.putIfAbsent(itemId, itemTotal);
                itemsPurchased.add(new OrderObj(itemId, qty, itemTotal));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //  System.out.println(items);
        return itemsPurchased;
    }

    private static float collateOrderTotal(List<OrderObj> orders) {
        float sum = 0;
        for (OrderObj order : orders) {
            sum += order.getTotalOnItem();
        }
        return sum;
    }


    // Exercise: Complete Sale class by adding following methods:
    // Add a method called createNewSale:
    // - collate the total price of all the items bought using the handleItemsTotal method
    // and log the total to the console.

    public static void createSaleAndOrder() {
        // Prompt the user for the customer id
        System.out.println("Enter the customer id: ");
        int custId = scanner.nextInt();

        // Get the items purchased
        List<OrderObj> itemsPurchased = handleItemTotal();

        // Get the total on the items
        float totalSale = collateOrderTotal(itemsPurchased);

        int saleId = 0;


        try {
            ps = connection.prepareStatement("INSERT INTO sales(customer_id, date_purchased, total)" +
                    "VALUES(" + custId + ", current_timestamp, " + totalSale + ") RETURNING id");        // needs salesId
            rs = ps.executeQuery();

            // Loop through the result set until empty
            while (rs.next()) {
                saleId = rs.getInt("id");
                // For each sale (later maybe multiple sales), use the id to create the orders.
                for (OrderObj orders : itemsPurchased) {      // another loop for orders (items purchased)
                    ps = connection.prepareStatement("INSERT INTO orders(sale_id, item_id, qty_purchased, item_total)" +
                            "VALUES(" + saleId + ", " + orders.getItemId() + ", " + orders.getQty_purchased() + ", " + orders.getTotalOnItem() + ")");
                    ps.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
