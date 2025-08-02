//Write a program that retrieves and displays column names,types and count of a ResultSet Using ResultSetMetaData
package assignment_jdbc;

import java.sql.*;

public class J013_ResultSetMetaData
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "admin";

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM student12");

            // Get ResultSetMetaData
            ResultSetMetaData rsMeta = rs.getMetaData();

            // Get column count
            int columnCount = rsMeta.getColumnCount();

            System.out.println("🧾 Total Columns: " + columnCount);
            System.out.println("📋 Column Details:\n");

            for (int i = 1; i <= columnCount; i++) {
                String colName = rsMeta.getColumnName(i);
                String colType = rsMeta.getColumnTypeName(i);
                System.out.println("Column " + i + ": " + colName + " (" + colType + ")");
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

