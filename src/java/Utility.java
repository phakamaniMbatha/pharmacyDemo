
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NKAZIMULO
 */
public class Utility {
    public static void sendEmail(String host, String port, final String senderEmail, String senderName, final String password, String recipientEmail,
            String subject, String message)throws AddressException, MessagingException, UnsupportedEncodingException{
        
        Properties pro = new Properties();
        pro.put("mail.smtp.host", host);
        pro.put("mail.smtp.port", port);
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.starttls.enable", "true");
        
        
        Authenticator auth;
        auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(senderEmail, password);
            }
        };
        
        Session session = Session.getInstance(pro, auth);
        
        MimeMessage msg = new MimeMessage(session);
        
        msg.setFrom(new InternetAddress(senderEmail, senderName));
        InternetAddress[] toAddresses = { new InternetAddress(recipientEmail)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
        
        Transport.send(msg);
}
                
    
}
