import java.io.*;
import java.net.*;
import java.util.*;

public class PingProgram {
  static void commands(ArrayList<String> commandList) throws Exception {
    ProcessBuilder build = new ProcessBuilder(commandList);
    Process process = build.start();

    BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
    BufferedReader Error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    String s = null;

    while ((s = input.readLine()) != null) {
      System.out.println(s);
    }
    System.out.println("Error (if any): ");
    while ((s = Error.readLine()) != null) {
      System.out.println(s);
    }
  }

  public static void sendPingRequest(String ipAddress) throws Exception {
    InetAddress ip = InetAddress.getByName(ipAddress);
    // System.out.println("Sending Ping Request to " + ipAddress);
    if (ip.isReachable(5000))
      System.out.println("Host is reachable");
    else
      System.out.println("Sorry ! The host is not reachable");
  }

  public static void main(String[] args) throws Exception {

    ArrayList<String> commandList = new ArrayList<String>();

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the IP Address/Domain Name:");
    String ipAddress = sc.nextLine();

    sendPingRequest(ipAddress);

    commandList.add("ping");
    commandList.add(ipAddress);
    commands(commandList);

    System.out.println("\nTracing route to IP Address/Domain Name " + ipAddress);
    commandList.clear();

    commandList.add("tracert");
    commandList.add(ipAddress);
    commands(commandList);

  }
}

// Test IP addresses
// 127.0.0.1 - accessible
// 133.192.31.42 - not accessible
// 145.154.42.58 - not accessible