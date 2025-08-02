//Write a program that performs the following operations on a MYSQL database 1.insert a new record 2.Update an Existing record 3.Select and display records 4.Delete a record
package LabAssignment;

import java.sql.*;
import java.util.Scanner;

public class L002_CRUD
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "admin";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            while (true)
            {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Insert Record");
                System.out.println("2. Update Record");
                System.out.println("3. Select & Display Records");
                System.out.println("4. Delete Record");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice)
                {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter First Name: ");
                        String fname = sc.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lname = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        String insertQuery = "INSERT INTO employees123 VALUES (?, ?, ?, ?)";
                        PreparedStatement pstmtInsert = con.prepareStatement(insertQuery);
                        pstmtInsert.setInt(1, id);
                        pstmtInsert.setString(2, fname);
                        pstmtInsert.setString(3, lname);
                        pstmtInsert.setString(4, email);
                        pstmtInsert.executeUpdate();
                        System.out.println("Record inserted successfully.");
                        break;

                    case 2:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter New Email: ");
                        String newEmail = sc.nextLine();

                        String updateQuery = "UPDATE employees123 SET email = ? WHERE emp_id = ?";
                        PreparedStatement pstmtUpdate = con.prepareStatement(updateQuery);
                        pstmtUpdate.setString(1, newEmail);
                        pstmtUpdate.setInt(2, uid);
                        int rows = pstmtUpdate.executeUpdate();
                        if (rows > 0)
                            System.out.println("Record updated successfully.");
                        else
                            System.out.println("Record not found.");
                        break;

                    case 3:
                        String selectQuery = "SELECT * FROM employees123";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(selectQuery);

                        System.out.println("\nID\tFirst Name\tLast Name\tEmail");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "\t" +
                                    rs.getString(2) + "\t\t" +
                                    rs.getString(3) + "\t\t" +
                                    rs.getString(4));
                        }
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();
                        String deleteQuery = "DELETE FROM employees123 WHERE emp_id = ?";
                        PreparedStatement pstmtDelete = con.prepareStatement(deleteQuery);
                        pstmtDelete.setInt(1, did);
                        int delRows = pstmtDelete.executeUpdate();
                        if (delRows > 0)
                            System.out.println("Record deleted successfully.");
                        else
                            System.out.println("Record not found.");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        con.close();
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
