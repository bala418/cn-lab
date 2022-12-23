import java.io.*;
import java.net.*;

class GetServer {

    static String sendGET(String GET_URL) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Google Chrome");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // System.out.println(response.toString());
            return (response.toString());
        } else {
            System.out.println("GET request not worked");
            return (null);
        }
    }

    public static void main(String a[]) throws Exception {
        ServerSocket ss = new ServerSocket(6789);
        Socket connectionSocket = ss.accept();
        BufferedReader ifs = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        PrintStream ps = new PrintStream(connectionSocket.getOutputStream());
        String sentence = ifs.readLine();
        String ms = sendGET(sentence);
        ps.println(ms);

        connectionSocket.close();

    }
}