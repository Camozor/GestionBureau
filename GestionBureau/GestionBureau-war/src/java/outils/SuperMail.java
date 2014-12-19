/*
 * Classe d'envoi de mail
 */
package outils;


import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 10900286
 */
public class SuperMail {
    public int sendMail(String email, String message){
        try
        {
            String to = email;
            String from = "paul.bismuth44@gmail.com";
            String subject = "Message de l'administrateur de gestion de bureaux : ";
            String smtpServ = "upn.univ-paris13.fr";

            
            Properties props = System.getProperties();
              props.put("mail.transport.protocol", "smtp" );
              props.put("mail.smtp.starttls.enable","true" );
              props.put("mail.smtp.host",smtpServ);
              props.put("mail.smtp.auth", "true" );
              Authenticator auth = new SMTPAuthenticator();
              Session session = Session.getInstance(props, auth);

              Message msg = new MimeMessage(session);

              msg.setFrom(new InternetAddress(from));
              msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
              msg.setSubject(subject);
              msg.setText(message);

              msg.setHeader("Gestion de bureau", "Administrateur" );
              msg.setSentDate(new Date());

              Transport.send(msg);
              return 0;
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
          System.out.println("Exception "+ex);
          return -1;
        }
  }
    
    private class SMTPAuthenticator extends javax.mail.Authenticator {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            String username =  "paul.bismuth44";           // specify your email id here (sender's email id)
            String password = "pass44word";                                      // specify your password here
            return new PasswordAuthentication(username, password);
        }
    }

}