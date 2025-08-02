//Create a stored procedure in MYSQL with IN and OUT parameters(e.g. a procedure that takes an employee ID as employee ID as input and returns the employee's full name as output)
package assignment_jdbc;

import java.sql.*;

public class J020_StoredProcedure
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "admin";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            CallableStatement stmt = con.prepareCall("{call get_full_name(?, ?)}");

            // Set IN parameter
            stmt.setInt(1, 101);

            // Register OUT parameter
            stmt.registerOutParameter(2, Types.VARCHAR);

            // Execute stored procedure
            stmt.execute();

            // Retrieve OUT parameter
            String fullName = stmt.getString(2);
            System.out.println("Full Name: " + fullName);

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
