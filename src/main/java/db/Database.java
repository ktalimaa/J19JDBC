package db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Database class provides connection with Java code and database itself

public class Database {

    public static Connection DbConn() {
        // Declare the connection outside the try/catch block to allow you to return it after the commands
        // have been executed.

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://babar.db.elephantsql.com/obvqxfuu",
                    "obvqxfuu",
                    "yCKCoJsOffyvHzs-eu7sOY0MSZjZ6T5S");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;      // we use this method any time, when we need to connect to the database
    }

    // reaching into the database and make some request

    public static Session getHibSesh() {
        Session session = null;

        try {
            SessionFactory seshFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();           // linking java code to xml file

            session = seshFactory.openSession();        // creates new session, when we call this method (getHibSesh)
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return session;

    }


}
