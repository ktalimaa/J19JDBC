package controllers.menu;

import controllers.Customer;
import controllers.Item;
import controllers.Orders;
import controllers.Sales;

import java.util.Scanner;

public class Menu {
    // abstraction where user decides what to do - two tier architecture

    static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Items");
        System.out.println("2. Customer");
        System.out.println("3. Sale");
        System.out.println("4. Orders");

        System.out.println("-----------------");
        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                itemsMenu();
                break;
            case 2:
                customerMenu();
                break;
            case 3:
                salesMenu();
                break;
            case 4:
                ordersMenu();
                break;
            default:
                System.out.println("Invalid option!");
                mainMenu();
                break;
        }
    }

    public static void itemsMenu() {
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Get All Items");
        System.out.println("2. Create New Item");

        System.out.println("-----------------");
        System.out.println("Select an option or enter 0 to go back to main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:     // need to reach Items class and pick a method what is related to that
                Item.getAllItems();
                itemsMenu();        // option or entering 0 and going back to main menu
                break;
            case 2:
                Item.createNewItem();
                itemsMenu();
                break;
            default:
                System.out.println("Invalid option!");
                itemsMenu();
                break;
        }
    }

    public static void customerMenu() {
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Get All Customers");
        System.out.println("2. Create New Customer");
        System.out.println("3. Update Customer");
        System.out.println("4. Delete Customer");

        System.out.println("-----------------");
        System.out.println("Select an option or enter 0 to go back to main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:     // need to reach Items class and pick a method what is related to that
                Customer.getAllCustomers();
                customerMenu();
                break;
            case 2:
                Customer.createNewCustomer();
                customerMenu();
                break;
            case 3:
                Customer.updateCustomer();
                customerMenu();
                break;
            case 4:
                Customer.deleteCustomer();
                customerMenu();
                break;
            default:
                System.out.println("Invalid option!");
                customerMenu();
                break;
        }
    }

    public static void ordersMenu() {
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Get All Orders");

        System.out.println("-----------------");
        System.out.println("Select an option or enter 0 to go back to main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Orders.getAllOrders();
                ordersMenu();
                break;
            default:
                System.out.println("Invalid option!");
                ordersMenu();
                break;
        }
    }

    public static void salesMenu() {
        System.out.println("Pick a submenu to continue: ");
        System.out.println("1. Get Sale Total");
        System.out.println("2. Create New Sale and Orders");

        System.out.println("-----------------");
        System.out.println("Select an option or enter 0 to go back to main menu: ");
        int option = scanner.nextInt();

        switch (option) {
            case 0:
                mainMenu();
                break;
            case 1:
                Sales.getAllSales();
                salesMenu();
                break;
            case 2:
                Sales.createSaleAndOrder();
                salesMenu();
                break;
            default:
                System.out.println("Invalid option!");
                salesMenu();
        }
    }
}
