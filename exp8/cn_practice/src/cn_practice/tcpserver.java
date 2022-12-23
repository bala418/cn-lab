/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cn_practice;
import java.net.*;
import java.io.*;
/**
 *
 * @author bala9
 */
public class tcpserver {
    public static void main(String[] args)throws IOException{
        ServerSocket ss=new ServerSocket(8080);
        Socket s=ss.accept();
        if(s.isConnected()){
            System.out.println("Client connected....");
        }
        DataInputStream din=new DataInputStream(s.getInputStream());
        while(true){
            String str=din.readUTF();
            if(str.equals("exit")){
                System.out.println("Client Disconnected....");
                break;
            }
            System.out.println("Client : "+str);
        }
        s.close();
        ss.close();
    }
}
