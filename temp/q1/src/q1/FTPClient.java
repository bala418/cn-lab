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


public class FTPClient {
       public static void main(String args[]) throws Exception{
           Socket s = new Socket("localhost", 9999);
            
           InputStream is=s.getInputStream();
           FileOutputStream fo=new FileOutputStream("received.txt");
           
           byte b[]=new byte[200];
           is.read(b, 0, b.length);
           fo.write(b, 0, b.length);
           
           System.out.println("File received");
           
           
           
       }
}
