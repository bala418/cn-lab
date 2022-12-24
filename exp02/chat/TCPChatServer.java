
import java.io.*;
import java.net.*;

public class TCPChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();

        BufferedReader socketin = new BufferedReader(new InputStreamReader(s.getInputStream()));

        PrintStream socketout = new PrintStream(s.getOutputStream());

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String msg, inp;

        System.out.println("Connected");

        while (true) {
            msg = socketin.readLine();
            if (msg.equals("bye")) {
                break;
            }

            System.out.print("Recieved Message : " + msg + "\n");
            inp = stdin.readLine();

            socketout.println(inp);
        }

        s.close();
        socketin.close();
        socketout.close();
        ss.close();
    }
}
