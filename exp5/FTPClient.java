import java.io.*;
import java.net.*;

public class FTPClient {
    public static void main(String[] args) throws Exception {
        Socket csocket = new Socket("localhost", 9999);
        InputStream is = csocket.getInputStream();

        FileOutputStream fo = new FileOutputStream("js2.jfif");

        byte b[] = new byte[10000];
        is.read(b, 0, b.length);
        fo.write(b, 0, b.length);
        System.out.println("File saved successfully!");
    }
}
