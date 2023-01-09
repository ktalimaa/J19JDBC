import db.Database;
import entities.Items;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        // to get all items, we need to call Item class

   /*

        Customer.createCustomerTable();     // checking if the table is created, primary check
        Item.createItemsTable();
        Sales.createSalesTable();
        Orders.createOrdersTable();

        Menu.mainMenu();

    */

        // subsequent objects will have their create table methods here

        // Add two features to this application that allows user
        // to view all the orders and all the sales.



        // HIBERNATE

       /*

        Session session = Database.getHibSesh();


        entities.Customer cust = session.find(entities.Customer.class, 2);
        System.out.println(cust);

        entities.Customer barry = new entities.Customer("Barry", "Allen", "barry@gmail.com");

        try {
            Transaction trans = session.beginTransaction();
            session.save(barry);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        */


        // Using Hibernate create the entity object for the items class and make find queries
        // on the items table to retrieve any items you previously stored to it.

        Session session = Database.getHibSesh();

        Items items = session.find(Items.class, 2);
        System.out.println(items);

        // Also, demonstrate how you would save a new entry into the items table.

        Items cake = new Items("Tiramisu", "Cake with layers");

        try {
            Transaction trans = session.beginTransaction();
            session.save(cake);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }






    }
}



