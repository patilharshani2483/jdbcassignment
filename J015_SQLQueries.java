//Write Sql queries for:Inserting a record into a table ,Updating the specific fields of record,Selecting records on certain conditions,Deleting specific records
package assignment_jdbc;

import java.sql.*;

public class J015_SQLQueries
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "admin";

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            // 1. INSERT (Make sure student_id doesn't duplicate if not auto_increment)
            String insertQuery = "INSERT INTO student12 (student_id, student_name, course, department, percentage, admission_date) " +
                    "VALUES (9001, 'Harshani Patil', 'B.Tech', 'Java', 78.5, '2024-07-31')";
            st.executeUpdate(insertQuery);
            System.out.println("Record inserted.");

            // 2. UPDATE (Update specific field)
            String updateQuery = "UPDATE student12 SET percentage = 80.5 WHERE student_id = 6";
            st.executeUpdate(updateQuery);
            System.out.println("Record updated.");

            // 3. SELECT (Display all records)
            String selectQuery = "SELECT * FROM student12 WHERE percentage > 70";
            ResultSet rs = st.executeQuery(selectQuery);
            System.out.println("\nStudents with percentage > 70:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " - " +
                                rs.getString("student_name") + " - " +
                                rs.getString("course") + " - " +
                                rs.getString("department") + " - " +
                                rs.getDouble("percentage") + " - " +
                                rs.getDate("admission_date")
                );
            }

            // 4. DELETE (Delete specific record)
            String deleteQuery = "DELETE FROM student12 WHERE student_id = 6";
            st.executeUpdate(deleteQuery);
            System.out.println("\nRecord deleted.");

            // Close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
