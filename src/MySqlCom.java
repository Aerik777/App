import java.sql.*;

public class MySqlCom {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYAPP", "root", "root");
            Statement stmt = con.createStatement();
            String q1 = "insert into info values(1,'Ram')";

            int x = stmt.executeUpdate(q1);
            if (x > 0){
                System.out.println("Succesfully inserted");
            } else {
                System.out.println("Insert Fail");
            }
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
