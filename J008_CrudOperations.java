//Write a java Program that performs the following CRUD operations
package assignment_jdbc;

import java.sql.*;
import java.util.Scanner;

public class J008_CrudOperations {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "admin";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                Scanner sc = new Scanner(System.in)
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to Database!");

            while (true) {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Insert Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice)
                {
                    case 1:
                        // INSERT
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter Percentage: ");
                        double percent = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter Admission Date (yyyy-mm-dd): ");
                        String date = sc.nextLine();

                        String insertQuery = "INSERT INTO student12 VALUES (?, ?, ?, ?, ?, ?)";
                        PreparedStatement psInsert = con.prepareStatement(insertQuery);
                        psInsert.setInt(1, id);
                        psInsert.setString(2, name);
                        psInsert.setString(3, course);
                        psInsert.setString(4, dept);
                        psInsert.setDouble(5, percent);
                        psInsert.setDate(6, Date.valueOf(date));
                        psInsert.executeUpdate();
                        System.out.println("Inserted Successfully!");
                        break;

                    case 2:
                        // SELECT
                        String selectQuery = "SELECT * FROM student12";
                        PreparedStatement psSelect = con.prepareStatement(selectQuery);
                        ResultSet rs = psSelect.executeQuery();

                        System.out.println("\n--- Student Records ---");
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
                        break;

                    case 3:
                        // UPDATE
                        System.out.print("Enter ID of student to update: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter new Percentage: ");
                        double newPercent = sc.nextDouble();

                        String updateQuery = "UPDATE student12 SET percentage = ? WHERE student_id = ?";
                        PreparedStatement psUpdate = con.prepareStatement(updateQuery);
                        psUpdate.setDouble(1, newPercent);
                        psUpdate.setInt(2, updateId);
                        int updatedRows = psUpdate.executeUpdate();
                        if (updatedRows > 0)
                            System.out.println("Updated Successfully!");
                        else
                            System.out.println("Student ID not found.");
                        break;

                    case 4:
                        // DELETE
                        System.out.print("Enter ID of student to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = "DELETE FROM student12 WHERE student_id = ?";
                        PreparedStatement psDelete = con.prepareStatement(deleteQuery);
                        psDelete.setInt(1, deleteId);
                        int deletedRows = psDelete.executeUpdate();
                        if (deletedRows > 0)
                            System.out.println("Deleted Successfully!");
                        else
                            System.out.println("Student ID not found.");
                        break;

                    case 5:
                        // EXIT
                        System.out.println("Exiting Program...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
