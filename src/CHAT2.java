import java.io.*;
import java.net.*;

public class CHAT2 {
    //server
    public static void main(String[] args) {
        
        try {
            ServerSocket ss = new ServerSocket(3333);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("Stop")) {
                str = din.readUTF();
                System.out.println("CLient says "+str);

                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }
            din.close();
            ss.close();
            s.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
    
}
