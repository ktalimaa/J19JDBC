import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getAllItems();

    }

    public static void getAllItems() {
        Connection connection = Database.DbConn();
        PreparedStatement ps;
        ResultSet rs;
        Scanner scanner = new Scanner(System.in);

        // Get all items

        try {
            ps = connection.prepareStatement("SELECT * FROM items");
            rs = ps.executeQuery();     // prepareStatement will write sql in

            // now we loop through the result set
            while (rs.next()) {     // calls next record of the table as long as the query has the result
                String id = "id: " + rs.getInt("id");
                String name = "name: " + rs.getString("name");      // when using int or string, calls column name
                String desc = "desc: " + rs.getString("description");
                String qty = "qty: " + rs.getInt("gty_in_stock");
                String price = "price: " + rs.getFloat("price");

                System.out.println(id + " " + name + " " + desc + " " + qty + " " + price + " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



