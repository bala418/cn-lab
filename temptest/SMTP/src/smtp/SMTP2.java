/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smtp;

/**
 *
 * @author bala9
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.*;
import javax.mail.internet.*;

public class SMTP2 {

    public static void main(String[] args) {
        String to = "asjawahar05052003@gmail.com";
        String from = "jawajava748@gmail.com";
        String host = "smtp.gmail.com";
        
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("jawajava748@gmail.com", "zpjhvaziqkycrqwd");

            }

        });


        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    
            message.setSubject("SMTP Exercise 2");
    
            message.setContent(
              "<h2>Hi Jawahar </h2> <p>This message invovles using HTML to make mails pretty</p>",
             "text/html");
        
            System.out.println("Mail transporting");
         
            Transport.send(message);
            System.out.println("Mail recieved at receivers end");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
