//Write a Simple Java Program to Connect to a MYSQL database using JDBC
package assignment_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class J001_JDBC
{

    public static void main(String[] args)
    {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded...");

            // 2. Database connection details
            String url = "jdbc:mysql://localhost:3306/java";
            String username = "root";
            String password = "admin";

            // 3. Connect to the database
            Connection cn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established...");

            // 4. Execute query
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student12");

            // 5. Read and print data
            System.out.println("Student Records:\n");
            while (rs.next())
            {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                String course = rs.getString("course");
                String department = rs.getString("department");
                double percentage = rs.getDouble("percentage");
                String date = rs.getString("admission_date");

                System.out.println("ID: " + id +
                        ", Name: " + name +
                        ", Course: " + course +
                        ", Department: " + department +
                        ", Percentage: " + percentage +
                        ", Admission Date: " + date);
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

