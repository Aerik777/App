import java.sql.*;

public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdlc:mysql://localhost:3306/MYAPP", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from info");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "" + rs.getString(2));
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}

