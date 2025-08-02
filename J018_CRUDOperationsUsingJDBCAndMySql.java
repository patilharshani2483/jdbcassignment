//Implement CRUD Operations(insert,update,select,delete)Using JDBC and MySql
package assignment_jdbc;

import java.sql.*;
import java.util.Scanner;

public class J018_CRUDOperationsUsingJDBCAndMySql
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "admin";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in))
        {

            Class.forName("com.mysql.cj.jdbc.Driver");

            while (true) {
                System.out.println("\nCRUD Menu:");
                System.out.println("1. Insert Record");
                System.out.println("2. View Records");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        // Insert
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter First Name: ");
                        String fname = sc.next();
                        System.out.print("Enter Last Name: ");
                        String lname = sc.next();
                        System.out.print("Enter Email: ");
                        String email = sc.next();

                        String insertQuery = "INSERT INTO users12(id, fname, lname, email) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
                            pst.setInt(1, id);
                            pst.setString(2, fname);
                            pst.setString(3, lname);
                            pst.setString(4, email);
                            pst.executeUpdate();
                            System.out.println("Record inserted successfully.");
                        }
                        break;

                    case 2:
                        // Select
                        String selectQuery = "SELECT * FROM users12";
                        try (Statement stmt = con.createStatement();
                             ResultSet rs = stmt.executeQuery(selectQuery)) {
                            System.out.println("\nID\tFirst Name\tLast Name\tEmail");
                            while (rs.next()) {
                                System.out.println(rs.getInt("id") + "\t" +
                                        rs.getString("fname") + "\t\t" +
                                        rs.getString("lname") + "\t\t" +
                                        rs.getString("email"));
                            }
                        }
                        break;

                    case 3:
                        // Update
                        System.out.print("Enter ID to update: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter new Email: ");
                        String newEmail = sc.next();

                        String updateQuery = "UPDATE users12 SET email = ? WHERE id = ?";
                        try (PreparedStatement pst = con.prepareStatement(updateQuery)) {
                            pst.setString(1, newEmail);
                            pst.setInt(2, updateId);
                            int rows = pst.executeUpdate();
                            if (rows > 0) System.out.println("Record updated.");
                            else System.out.println("ID not found.");
                        }
                        break;

                    case 4:
                        // Delete
                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = "DELETE FROM users12 WHERE id = ?";
                        try (PreparedStatement pst = con.prepareStatement(deleteQuery)) {
                            pst.setInt(1, deleteId);
                            int rows = pst.executeUpdate();
                            if (rows > 0)
                            {
                                System.out.println("Record deleted.");

                            }
                            else
                            {
                                System.out.println("ID not found.");

                            }
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
