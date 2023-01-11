package entities;

import db.Database;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer")
@Data
@NoArgsConstructor
public class Customer {

    static Session session = Database.getHibSesh();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public static void createCustomer(Customer customer) {
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        try {
            session.persist(customer);
            session.flush();        // refreshes the connection?
            trans.commit();
        } catch (Exception e) {
            trans.rollback();   // if error comes up, everything goes back and you can try the operation again
            e.printStackTrace();
        }

    }


    public static void listCustomers() {
        Session session = Database.getHibSesh();
        // Transaction transaction = session.beginTransaction();


        try {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("from customer").list();     // returns all customers

            for (Customer customer : customers) {
                System.out.println(customer);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateCustomer(String firstName, int customerId) {
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        Customer cust = session.get(Customer.class, customerId);        // use scanner to ask user, which fields to update
        cust.setFirstName(firstName);

        try {
            session.merge(cust);          // merge can be used update also, difference that update can lose data, merge doesn't
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }

    public static void deleteCustomer(int customerId) {
        // NOTE: always recommended to use transactions when deleting something,
        // so in the event that you are carrying out other operations
        // which you want to occur simultaneously with the deletion
        // if there's error the entire operation is rolled back and nothing is deleted.
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        Customer cust = session.get(Customer.class, customerId);        // use scanner to ask user, which fields to update

        try {
            session.delete(cust);
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }


}
