// Demonstrate the process of loading a JDBC Driver and Establishing a Connection
package assignment_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class J002_JdbcConnection
{

    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "admin";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Loaded Successfully");

            // Establish the connection
            Connection cn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");

            // Close the connection
            cn.close();
            System.out.println("Connection Closed Successfully");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
