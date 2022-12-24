import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Mail_1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String SenderUser = "jawajava748";
        String SenderMail = "jawajava748@gmail.com";
        String SenderPassword = "";
        
        System.out.print("Enter Destination Address:");
        String ToMail = in.nextLine();
        String ToHost = "smtp.gmail.com";
        
        
        Properties SessionProperties = new Properties();
        SessionProperties.put("mail.smtp.auth","true");
        SessionProperties.put("mail.smtp.starttls.enable","true");
        SessionProperties.put("mail.smtp.host",ToHost);
        SessionProperties.put("mail.smtp.port",587);
        
        
        Session CurrentSession = Session.getInstance(SessionProperties,
            new javax.mail.Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(SenderMail, SenderPassword);
                }
            });
        try{
            Message ThisMessage = new MimeMessage(CurrentSession);
            
            ThisMessage.setFrom(new InternetAddress(SenderMail));
            ThisMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ToMail));
            System.out.print("Subject :");
            String Subject = in.nextLine();
            
            System.out.println("BOdy :");
            String Body = in.nextLine();
            
            ThisMessage.setSubject(Subject);
            ThisMessage.setContent(Body,"text/html");
            
            Transport.send(ThisMessage);
            System.out.println("Mail sent");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
