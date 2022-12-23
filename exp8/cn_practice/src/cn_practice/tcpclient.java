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
public class tcpclient {
    public static void main(String[] args)throws IOException{
        Socket s=new Socket("localhost",8080);
        DataOutputStream dout =new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        if(s.isConnected()){
            System.out.println("Connected...");
        }
        while(true){
            String str=br.readLine();
            dout.writeUTF(str);
            if(str.equals("exit")){
                System.out.println("Disconnected....");
                break;
            }
        }
        s.close();
    }
}
