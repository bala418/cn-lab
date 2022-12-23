/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bala9
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class Ping {
    public static void commands(ArrayList<String> commandList)throws Exception{
        ProcessBuilder b = new ProcessBuilder();
        Process p = b.start();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader be = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        
        String s = null;
        
        while((s= br.readLine())!=null){
            System.out.println(s);
        }
       
    }
    
    public static void PingRequest(String ipAdd) throws Exception{
        InetAddress ia = InetAddress.getByName(ipAdd);
        if(ia.isReachable(2000)){
//            
        }
    }
    
    public static void main(String []args) throws Exception{
        ArrayList<String> commandList = new ArrayList<String>();
        
        String x = "google.com";
        
        PingRequest(x);
        
        commandList.add("ping");
        commandList.add(x);
        commands(commandList);
        
        commandList.clear();
        
        commandList.add("tracert");
        commandList.add(x);
        commands(commandList);
        
    }
}
