import controllers.Customer;
import controllers.Item;
import controllers.menu.Menu;

import static controllers.Item.*;

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
        //Customer.getAllCustomers();
        Item.createItemsTable();
        // subsequent objects will have their create table methods here
        Menu.mainMenu();

    }
}



