/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

/**
 *
 * @author bala9
 */

import java.io.*;
import java.net.*;
public class FTPServer {
    public static void main(String args[]) throws Exception{
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();
        
        FileInputStream fis = new FileInputStream("send.txt");
        byte b[] = new byte[200];
        
        fis.read(b, 0, b.length);
        
        OutputStream os = s.getOutputStream();
        
        os.write(b, 0, b.length);
        
        System.out.println("File sent");
        
    }
}
