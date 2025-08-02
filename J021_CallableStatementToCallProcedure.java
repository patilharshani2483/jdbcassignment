//Write a java program that uses CallableStatement to call this stored procedure
package assignment_jdbc;

import java.sql.*;
import java.util.Scanner;

public class J021_CallableStatementToCallProcedure
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "admin";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                Scanner sc = new Scanner(System.in)
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();

            CallableStatement cstmt = con.prepareCall("{CALL get_full_name(?, ?)}");

            // Set input parameter
            cstmt.setInt(1, empId);

            // Register output parameter
            cstmt.registerOutParameter(2, Types.VARCHAR);

            // Execute stored procedure
            cstmt.execute();

            // Get output
            String fullName = cstmt.getString(2);
            System.out.println("Employee Full Name: " + fullName);

            cstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

