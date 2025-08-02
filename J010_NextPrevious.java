//Demonstrate how to navigate through the Resultset using methods like next(),Previous()
package assignment_jdbc;

import java.sql.*;

public class J010_NextPrevious
{
    public static void main(String[] args)
    {
        // Database connection info
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "admin";

        try {
            // 1. Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to DB
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database...");

            // 3. Create scrollable ResultSet
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM student12");

            System.out.println("\n(--- Using next() ---)");
            while (rs.next()) {
                System.out.println(rs.getInt("student_id") + " | " + rs.getString("student_name"));
            }

            System.out.println("\n(--- Using previous() ---)");
            while (rs.previous()) {
                System.out.println(rs.getInt("student_id") + " | " + rs.getString("student_name"));
            }

            System.out.println("\n(--- Using first() ---)");
            if (rs.first()) {
                System.out.println("First Record: " + rs.getInt("student_id") + " | " + rs.getString("student_name"));
            }

            System.out.println("\n(--- Using last() ---)");
            if (rs.last()) {
                System.out.println("Last Record: " + rs.getInt("student_id") + " | " + rs.getString("student_name"));
            }

            // 4. Close everything
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

