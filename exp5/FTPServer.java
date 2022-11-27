import java.io.*;
import java.net.*;

public class FTPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ssocket = new ServerSocket(9999);
        Socket socket = ssocket.accept();
        FileInputStream fr = new FileInputStream("js.jfif");

        byte b[] = new byte[20000];
        fr.read(b, 0, b.length);

        OutputStream os = socket.getOutputStream();
        os.write(b, 0, b.length);
        System.out.println("File sent succesfully!");
    }
}