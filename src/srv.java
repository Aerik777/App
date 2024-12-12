import java.io.*;
import java.net.*;

public class srv {
    public static void main(String[] args) {
        
        try {
            ServerSocket ss = new ServerSocket(5555);
            Socket s = ss.accept();

            DataInputStream din = new DataInputStream(s.getInputStream());

            String msg = (String)din.readUTF();
            System.out.println("Clinet says :"+ msg);
            ss.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
