//Use a SELECT query to display this metadata for a specific table
package assignment_jdbc;

import java.sql.*;

public class J014_MetaDataForSpecificTable
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String pass = "admin";

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection con = DriverManager.getConnection(url, user, pass);

            // Create statement and execute a query
            String tableName = "student12";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " LIMIT 1");

            // Get metadata
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();

            System.out.println("Metadata for table: " + tableName);
            System.out.println("Total Columns: " + columnCount);
            System.out.println();

            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ":");
                System.out.println("  Name       : " + meta.getColumnName(i));
                System.out.println("  Type       : " + meta.getColumnTypeName(i));
                System.out.println("  Size       : " + meta.getColumnDisplaySize(i));
                System.out.println("  Nullable   : " + (meta.isNullable(i) == ResultSetMetaData.columnNullable ? "YES" : "NO"));
                System.out.println();
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
