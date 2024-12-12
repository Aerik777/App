import java.sql.*;
import java.util.Scanner;

public class preparedstm {
     public static void main(String[] args) {
        int id;
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your id: ");
        id = sc.nextInt();

        System.out.println("Enter your name: ");
        name = sc.next();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYAPP", "root", "root");
           
           
            String q1 = "INSERT INTO INFO (id, name) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(q1);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            int x = stmt.executeUpdate();

            if(x > 0){
                System.out.println("Successfully inserted");
            }
            else{
                System.out.println("Insert failed");
                con.close();
            }
            String q2 = "select * from INFO";
            PreparedStatement selectstmt = con.prepareStatement(q2);
            ResultSet rs = selectstmt.executeQuery(q2);

            if(rs.next()){
                System.out.println("User-id : " + rs.getString(1));
                System.out.println("Name : " + rs.getString(2));
            }
            else{
                System.out.println("empty");
            }
            sc.close();
            stmt.close();
            selectstmt.close();
            con.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
