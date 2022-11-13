
import java.io.*;
import java.net.*;

public class TCPEchoClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 9999);

        BufferedReader socketin = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream socketout = new PrintStream(s.getOutputStream());

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String msg, inp;

        while (true) {
            System.out.print("Client : ");
            inp = stdin.readLine();
            socketout.println(inp);
            msg = socketin.readLine();
            System.out.println("Server Echo: " + msg);

            if (msg.equals("bye"))
                break;
        }

        s.close();
        socketin.close();
        socketout.close();

    }
}
