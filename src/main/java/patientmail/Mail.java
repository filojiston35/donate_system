/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Yusuf
 */
public class Mail {
    private String mail;
    private String nameSurname;
    private String patientKey;

    public Mail(String mail, String nameSurname, String patientKey) {
        this.mail = mail;
        this.nameSurname = nameSurname;
        this.patientKey = patientKey;
    }
    public Mail()
    {
        
    }
     public  void mailAt(){
             final String username = "kanbagissistemi2018@gmail.com";
             final String password = "asd01233210";
             Properties properties = new Properties();
             properties.put("mail.smtp.auth", "true");
             properties.put("mail.smtp.starttls.enable", "true");
             properties.put("mail.smtp.host", "smtp.gmail.com");
             properties.put("mail.smtp.port", "587");
 
             Session session = Session.getInstance(properties,
                           new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(username, password);
                    }
             }); 
             try {
 
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("biseyler@bisey.com"));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mail));
                    message.setSubject("Kan Bağış Sistemi");
                    message.setText("Sayın "+nameSurname+", çağrınız başarıyla gerçekleşmiştir.\n"
                            + "KEY:  "+patientKey+"\n"+"Acil şifalar diliyoruz."); 
                    Transport.send(message);
 
             } catch (MessagingException ex) {
                    throw new RuntimeException(ex);
             }
       }
        public void resetPassword(String createKey,String mailAdress)
        {
             final String username = "kanbagissistemi2018@gmail.com";
             final String password = "asd01233210";
             Properties properties = new Properties();
             properties.put("mail.smtp.auth", "true");
             properties.put("mail.smtp.starttls.enable", "true");
             properties.put("mail.smtp.host", "smtp.gmail.com");
             properties.put("mail.smtp.port", "587");
 
             Session session = Session.getInstance(properties,
                           new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(username, password);
                    }
             }); 
             try {
 
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("biseyler@bisey.com"));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(mailAdress));
                    message.setSubject("Kan Bağış Sistemi");
                    message.setText("Şifreniz başarıyla sıfırlanmıştır.\n Geçici olarak kullanabileceğiniz şifreniz:"+createKey); 
                    Transport.send(message);
 
             } catch (MessagingException ex) {
                    throw new RuntimeException(ex);
             }
        }
}
