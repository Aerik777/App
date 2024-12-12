import java.sql.*;
import java.util.Scanner;

public class parameteri {
    public static void main(String[] args) {
        int id;
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your id: ");
        id = sc.nextInt();

        System.out.println("Enter your name: ");
        name = sc.next();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYAPP", "root", "root");

            // Insert query with specified columns
            String q1 = "INSERT INTO INFO (id, name) VALUES (?, ?)";
            PreparedStatement insertStmt = con.prepareStatement(q1);
            insertStmt.setInt(1, id);
            insertStmt.setString(2, name);

            int x = insertStmt.executeUpdate();
            if (x > 0) {
                System.out.println("Successfully inserted");
            } else {
                System.out.println("Insert failed");
            }

            // Select query to fetch all rows
            String q2 = "SELECT * FROM INFO";
            PreparedStatement selectStmt = con.prepareStatement(q2);
            ResultSet rs = selectStmt.executeQuery();

            System.out.println("Data in the INFO table:");
            while (rs.next()) {
                System.out.println("User-id : " + rs.getInt(1));
                System.out.println("Name : " + rs.getString(2));
            }

            // Close resources
            rs.close();
            insertStmt.close();
            selectStmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
