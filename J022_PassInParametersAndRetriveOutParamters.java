//Demonstrate how to pass IN parameters and retrieve OUT parameters
package assignment_jdbc;

import java.sql.*;
import java.util.Scanner;

public class J022_PassInParametersAndRetriveOutParamters
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java"; // your DB name
        String user = "root";       // your MySQL username
        String password = "admin";  // your MySQL password

        try (Scanner sc = new Scanner(System.in))
        {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get user input for employee ID
            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Prepare the stored procedure call
            CallableStatement cstmt = con.prepareCall("{CALL get_full_name(?, ?)}");

            // Set IN parameter
            cstmt.setInt(1, empId);

            // Register OUT parameter
            cstmt.registerOutParameter(2, Types.VARCHAR);

            // Execute the stored procedure
            cstmt.execute();

            // Retrieve OUT parameter
            String fullName = cstmt.getString(2);

            // Output result
            if (fullName != null)
            {
                System.out.println("Full Name of Employee: " + fullName);
            }
            else
            {
                System.out.println("Employee not found.");
            }

            // Close resources
            cstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

