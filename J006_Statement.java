package assignment_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class J006_Statement
{
    public static void main(String[] args)
    {
        try {
            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded...");

            // 2. Establish Connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java", "root", "admin"
            );
            System.out.println("Database Connected...");

            // 3. Create Statement object
            Statement stmt = conn.createStatement();

            // INSERT
            String insertQuery = "INSERT INTO student122 VALUES (24, 'Harshani Patil', 'Surat')";
            int insertCount = stmt.executeUpdate(insertQuery);
            System.out.println("Insert Successful. Rows affected: " + insertCount);

            // UPDATE
            String updateQuery = "UPDATE student122 SET city = 'Pune' WHERE id = 10";
            int updateCount = stmt.executeUpdate(updateQuery);
            System.out.println("Update Successful. Rows affected: " + updateCount);

            // DELETE
            String deleteQuery = "DELETE FROM student122 WHERE id = 10";
            int deleteCount = stmt.executeUpdate(deleteQuery);
            System.out.println("Delete Successful. Rows affected: " + deleteCount);

            // 4. Close connection
            System.out.println("Connection Closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
