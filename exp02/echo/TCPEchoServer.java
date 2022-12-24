import java.io.*;
import java.net.*;

public class TCPEchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();

        BufferedReader socketin = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream socketout = new PrintStream(s.getOutputStream());


        String msg;

        while (true) {
            msg = socketin.readLine();
            if (msg.equals("bye")) {
                socketout.println("bye");
                break;
            }

            System.out.print("Client : " + msg + "\n");
            socketout.println(msg);
        }

        s.close();
        socketin.close();
        socketout.close();
        ss.close();
    }
}
