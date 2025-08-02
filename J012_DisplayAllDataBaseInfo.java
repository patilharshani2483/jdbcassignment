//Display database name,version,list of tables and supported SQL features
package assignment_jdbc;

import java.sql.*;

public class J012_DisplayAllDataBaseInfo
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "admin";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Get database metadata
            DatabaseMetaData dbMeta = con.getMetaData();

            // Display database information
            System.out.println("✅ Database Info:");
            System.out.println("Database Name: " + dbMeta.getDatabaseProductName());
            System.out.println("Database Version: " + dbMeta.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbMeta.getDriverName());
            System.out.println("Driver Version: " + dbMeta.getDriverVersion());

            // Display list of tables
            System.out.println("\n📋 List of Tables:");
            ResultSet tables = dbMeta.getTables(null, null, "%", new String[] { "TABLE" });
            while (tables.next()) {
                System.out.println("- " + tables.getString("TABLE_NAME"));
            }

            // Display supported SQL features
            System.out.println("\n⚙️ Supported SQL Features:");
            System.out.println("Supports Transactions: " + dbMeta.supportsTransactions());
            System.out.println("Supports Stored Procedures: " + dbMeta.supportsStoredProcedures());
            System.out.println("Supports Batch Updates: " + dbMeta.supportsBatchUpdates());
            System.out.println("Supports Outer Joins: " + dbMeta.supportsOuterJoins());
            System.out.println("Supports Full Outer Joins: " + dbMeta.supportsFullOuterJoins());
            System.out.println("Supports ANSI92 Entry Level SQL: " + dbMeta.supportsANSI92EntryLevelSQL());

            // Close connections
            tables.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
