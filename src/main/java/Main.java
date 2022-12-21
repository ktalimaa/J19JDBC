import controllers.Customer;
import controllers.Item;
import controllers.Orders;
import controllers.Sales;
import controllers.menu.Menu;

public class Main {
    public static void main(String[] args) {

        // to get all items, we need to call Item class

        Customer.createCustomerTable();     // checking if the table is created, primary check
        Item.createItemsTable();
        Sales.createSalesTable();
        Orders.createOrdersTable();

        Menu.mainMenu();

        // subsequent objects will have their create table methods here

    }

    // Add two features to this application that allows user
    // to view all the orders and all the sales.


}



