import java.sql.*;
import java.util.*;

public class implementsql {
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
            Statement stmt = con.createStatement();
            String q1 = "insert into info values('"+id+"','"+name+"')";
            String q2 = "select * from INFO";

            int x = stmt.executeUpdate(q1);
            ResultSet rs = stmt.executeQuery(q2);
            if(x > 0){
                System.out.println("Successfully inserted");
            }
            else{
                System.out.println("Insert failed");
                con.close();
            }

            if(rs.next()){
                System.out.println("User-id : " + rs.getString(1));
                System.out.println("Name : " + rs.getString(2));
            }
            else{
                System.out.println("empty");
            }
            sc.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
