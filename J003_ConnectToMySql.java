//Identify which driver your java program uses to connect to mysql
package assignment_jdbc;

public class J003_ConnectToMySql
{
    public static void main(String[] args)
    {
        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver used: com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }
}
