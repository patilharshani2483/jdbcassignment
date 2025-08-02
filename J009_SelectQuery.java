//Write a program that executes a SELECT query and processes the Resultset to display records from the database
package assignment_jdbc;

import java.sql.*;

public class J009_SelectQuery
{
    public static void main(String[] args)
    {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "admin";

        try
        {
            // 1. Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database...");

            // 3. Write SELECT query
            String query = "SELECT * FROM student12";

            // 4. Create Statement and execute query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // 5. Process ResultSet
            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                String course = rs.getString("course");
                String dept = rs.getString("department");
                double percent = rs.getDouble("percentage");
                Date date = rs.getDate("admission_date");

                System.out.println(id + " | " + name + " | " + course + " | " + dept + " | " + percent + " | " + date);
            }

            // 6. Close connections
            rs.close();
            stmt.close();
            con.close();
            System.out.println("\nData fetched successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

