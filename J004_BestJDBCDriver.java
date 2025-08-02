package assignment_jdbc;

public class J004_BestJDBCDriver {
    public static void main(String[] args)
    {
        System.out.println("[=== JDBC Driver Research ===]");


        System.out.println("Best JDBC Driver for MySQL: com.mysql.cj.jdbc.Driver");
        System.out.println();

        System.out.println("Why this driver?");
        System.out.println("1. Official MySQL Connector/J driver provided by Oracle.");
        System.out.println("2. Fully compatible with MySQL 5.5+ and MySQL 8.0+.");
        System.out.println("3. Supports modern JDBC features (JDBC 4.2, 4.3).");
        System.out.println("4. Actively maintained and optimized for performance.");
        System.out.println("5. Works well with Java SE 8 and newer versions.");

        System.out.println();

        System.out.println("Driver Class Name: com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC URL Format: jdbc:mysql://<host>:<port>/<database>");
        System.out.println("Example URL: jdbc:mysql://localhost:3306/java");

        System.out.println();

        System.out.println("✅ Recommended for most Java + MySQL applications.");
    }
}
