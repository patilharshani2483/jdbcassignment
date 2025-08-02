//Modify the program to use PreparedStatement for parameterized queries
package assignment_jdbc;

import java.sql.*;
import java.util.Scanner;

public class J007_PreparedStatement
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "admin";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                Scanner sc = new Scanner(System.in)
        )
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to MySQL database!");

            // INSERT
            String insertQuery = "INSERT INTO student12 (student_id, student_name, course, department, percentage, admission_date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insertQuery);
            psInsert.setInt(1, 433);
            psInsert.setString(2, "Harshani Patil");
            psInsert.setString(3, "B.Tech");
            psInsert.setString(4, "Java");
            psInsert.setDouble(5, 78.5);
            psInsert.setDate(6, Date.valueOf("2024-07-31"));
            psInsert.executeUpdate();
            System.out.println("Data Inserted Successfully.");

            // UPDATE
            String updateQuery = "UPDATE student12 SET percentage = ? WHERE student_id = ?";
            PreparedStatement psUpdate = con.prepareStatement(updateQuery);
            psUpdate.setDouble(1, 80.0);
            psUpdate.setInt(2, 4);
            psUpdate.executeUpdate();
            System.out.println("Data Updated Successfully.");

            // DELETE
            String deleteQuery = "DELETE FROM student12 WHERE student_id = ?";
            PreparedStatement psDelete = con.prepareStatement(deleteQuery);
            psDelete.setInt(1, 2);
            psDelete.executeUpdate();
            System.out.println("Data Deleted Successfully.");

            // SELECT
            String selectQuery = "SELECT * FROM student12";
            PreparedStatement psSelect = con.prepareStatement(selectQuery);
            ResultSet rs = psSelect.executeQuery();

            System.out.println("\n[--- Student Records ---]");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " | " +
                                rs.getString("student_name") + " | " +
                                rs.getString("course") + " | " +
                                rs.getString("department") + " | " +
                                rs.getDouble("percentage") + " | " +
                                rs.getDate("admission_date")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
