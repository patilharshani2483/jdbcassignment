//Write a java program that calls the stored procedure using callableStatement and demonstrates how to pass parameters and retrieve results
package LabAssignment;

import java.sql.*;

public class L007_CallableStatement
{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "admin";

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // 3. Prepare CallableStatement for stored procedure
            CallableStatement cs = conn.prepareCall("{call getUserDetailsById(?, ?, ?, ?)}");

            // 4. Set IN parameter
            cs.setInt(1, 1234); // Provide existing ID from your 'usersjdbc' table

            // 5. Register OUT parameters
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);

            // 6. Execute stored procedure
            cs.execute();

            // 7. Retrieve OUT values
            String fname = cs.getString(2);
            String lname = cs.getString(3);
            String email = cs.getString(4);

            // 8. Print output
            System.out.println("User Details:");
            System.out.println("First Name: " + fname);
            System.out.println("Last Name : " + lname);
            System.out.println("Email     : " + email);

            // 9. Close connection
            cs.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

