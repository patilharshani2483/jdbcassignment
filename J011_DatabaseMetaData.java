//Write a program that retrieves and displays metadata information about your database using DatabaseMetaData
package assignment_jdbc;

import java.sql.*;

public class J011_DatabaseMetaData
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "admin";

        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database...\n");

            // 3. Get DatabaseMetaData
            DatabaseMetaData dbMeta = con.getMetaData();

            // 4. Display metadata info
            System.out.println("Database Product Name: " + dbMeta.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbMeta.getDatabaseProductVersion());
            System.out.println("Database Driver Name: " + dbMeta.getDriverName());
            System.out.println("Database Driver Version: " + dbMeta.getDriverVersion());
            System.out.println("Username: " + dbMeta.getUserName());
            System.out.println("URL: " + dbMeta.getURL());
            System.out.println("Supports Transactions: " + dbMeta.supportsTransactions());
            System.out.println("Supports Stored Procedures: " + dbMeta.supportsStoredProcedures());

            // 5. Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
