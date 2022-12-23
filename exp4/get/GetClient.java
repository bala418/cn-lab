import java.io.*;
import java.net.*;

class GetClient {
    public static void main(String a[]) throws Exception {
        Socket clientSocket = new Socket("localhost", 6789);
        BufferedReader ifu = new BufferedReader(new InputStreamReader(System.in));
        PrintStream ots = new PrintStream(clientSocket.getOutputStream());
        BufferedReader ifs = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Enter the URL");
        String sentence = ifu.readLine();
        ots.println(sentence + '\n');
        String ms = ifs.readLine();
        System.out.println(ms);
        clientSocket.close();
    }
}