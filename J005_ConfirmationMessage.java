//Write a Java Program to establish a Connection to a database and print a confirmation message upon successful connection
package assignment_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class J005_ConfirmationMessage
{
    public static void main(String[] args)
    {

        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "admin";

        try
        {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");

            // Establish the connection
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully to the database!");

            // Close the connection
            conn.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
