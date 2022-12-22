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

    // Create a table that called Students and another table called Grades
    // The fields/columns on the student table should be as follows: id, name, age
    // create obj of studs or table of courses.
    // Complete the controllers for the students table by adding methods to handle CRD operations on each record in the table.

    // On the Grades table, store the student's id, score and the Grade where for each Grade:
    // The columns on Grades should be: id, student_id, score.
    // 0 - 40 = F, 41 - 49 = D, 50 - 59 = C, 60 - 69 = B, 70 - 100 = A
    // Complete the controller for the Grades table to have Create, Read and Delete operations.
    // For read operation, you should be able to see the students information as well.





}



