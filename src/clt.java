import java.io.*;
import java.net.*;

public class clt {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5555);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Message from the client");
            dout.flush();
            dout.close();
            s.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
