//Write a Java program that connects to a MYSQL database and executes a simple query to retrieve all records from a table
package LabAssignment;

import java.sql.*;

public class L001_RetrieveAllRecords
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "admin";

        try
        {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Create statement
            Statement stmt = con.createStatement();

            // Execute query
            String query = "SELECT * FROM employees123";
            ResultSet rs = stmt.executeQuery(query);

            // Display results
            System.out.println("Emp_ID\tFirst_Name\tLast_Name\tEmail");
            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String email = rs.getString("email");

                System.out.println(id + "\t" + fname + "\t\t" + lname + "\t\t" + email);
            }




        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
