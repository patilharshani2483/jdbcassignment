//Create a stored procedure in MYSQL with IN and OUT parameters
package LabAssignment;

import java.sql.*;

public class L006_StoredProcedure
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/java";
        String user = "root";
        String password = "admin";

        try (Connection conn = DriverManager.getConnection(url, user, password))
        {
            CallableStatement stmt = conn.prepareCall("{call getUserFullNameNew(?, ?)}");

            stmt.setInt(1, 1234); //
            stmt.registerOutParameter(2, Types.VARCHAR);

            stmt.execute();

            String fullName = stmt.getString(2);
            System.out.println("Full Name: " + fullName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
