import controllers.Customer;
import controllers.Item;
import controllers.menu.Menu;

public class Main {
    public static void main(String[] args) {

        // to get all items, we need to call Item class
        // Item.getAllItems();

        // Item.createNewItem();
        // Item.getAllItems();

        //Item.updateItem();
        //Item.getAllItems();

        //Item.deleteItem();
        //Item.getAllItems();

        //Item.getItemById();


        Customer.createCustomerTable();     // checking if the table is created, primary check
        // Customer.getAllCustomers();
        // System.out.println();
        Item.createItemsTable();
        // System.out.println();
        // Orders.getAllOrders();
        // System.out.println();
        // Sales.getAllSales();
        // System.out.println();
        // subsequent objects will have their create table methods here
        Menu.mainMenu();
    }

    // Add two features to this application that allows user
    // to view all the orders and all the sales.



}



