import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class SendMailBySite {  
 public static void main(String[] args) {  
  
  String host="smtp.gmail.com";  
  final String user="";//your email id
  final String password="";//put your password
    
  String to=""; //recepient email id
  
  System.out.println("praparing :") ;
   //Get the session object  
   Properties props = new Properties();  
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.auth", "true"); 
   props.put("mail.smtp.port" , "587") ;
   props.put("mail.smtp.starttls.enable", "true") ;
     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("Congratulations");  
     message.setText("Prasheet Did Some Java Work .....");  
       
    //send the message  
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
 }  
}  