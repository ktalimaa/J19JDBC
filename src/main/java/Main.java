import db.Database;
import entities.Customer;
import entities.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session = Database.getHibSesh();
        //Customer.listCustomers();

        // entities.Customer minaj = new entities.Customer("Nikki", "Minaj", "nikki@gmail.com");
        //Customer.createCustomer(minaj);
        //Customer.listCustomers();


        //    Customer minaj = new Customer("Nikki", "Minaj", "nikki@gmail.com");
        //Customer minaj = new Customer();
        // minaj.setFirstName("Billy");

        Customer.updateCustomer("David", 4);
        Customer.listCustomers();

        // System.out.println(minaj);


        // to get all items, we need to call Item class

   /*

        Customer.createCustomerTable();     // checking if the table is created, primary check
        Item.createItemsTable();
        Sale.createSalesTable();
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


        /*

        // Using Hibernate create the entity object for the items class and make find queries
        // on the items table to retrieve any items you previously stored to it.

        Session session = Database.getHibSesh();

        Items items = session.find(Items.class, 2);
        System.out.println(items);

         */


        /*

        // Also, demonstrate how you would save a new entry into the items table.

        Items cake = new Items("Tiramisu", "Cake with layers");

        try {
            Transaction trans = session.beginTransaction();
            session.save(cake);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

         */


        //Sale sale = session.find(Sale.class, 2);
        //  System.out.println(sale);


        // Using hibernate create the entity object for the orders class and
        // make find queries on the order table to test your work.

        // Order order = session.find(Order.class, 1);
        // System.out.println(order);

        // - How to hack the select * from [from anything]; query
        // - differences between certain hibernate methods (transactions?)

        // separate method to always call it later
        // another way for it is to add static method each class

        // Customer.listCustomers();


    }


}



