package org.jack;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {



        System.out.println( "Mail Application!" );
        App.sendMail("mail is sent by code of java","Mails sending module using java","guptajagdish9756@gmail.com","varshneyjacky@gmail.com");
        App.sendfilebyMail("mail is sent by code of java","file sending module using java","guptajagdish9756@gmail.com","varshneyjacky@gmail.com");


    }

public static void sendMail(String msgS, String sub, String to, String from){
    Properties prop= System.getProperties();
    prop.put("mail.smtp.host","smtp.gmail.com");
    prop.put("mail.smtp.port","465");
    prop.put("mail.smtp.ssl.enable","true");
    prop.put("mail.smtp.suth","true");
    Session session=Session.getInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("varshneyjacky@gmail.com","Vj@987068");
        }
    });
    MimeMessage msg= new MimeMessage(session);
    try{
            msg.setFrom(from);
        msg.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress(to));
        msg.setSubject(sub);
        msg.setText(msgS);
        Transport.send(msg);
        System.out.println("mail send successfully");
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}


    public static void sendfilebyMail(String msgS, String sub, String to, String from){
        Properties prop= System.getProperties();
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port","465");
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.suth","true");
        Session session=Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("varshneyjacky@gmail.com","Vj@987068");
            }
        });
        MimeMessage msg= new MimeMessage(session);
        try{
            msg.setFrom(from);
            msg.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress(to));
            msg.setSubject(sub);
            MimeMultipart mp= new MimeMultipart();
            MimeBodyPart mb= new MimeBodyPart();
            MimeBodyPart mb2= new MimeBodyPart();
            mb2.setText(msgS);
            String path="C:\\Users\\jagdish gupta\\Desktop\\photo.jpeg";

            File f=new File(path);
            try{
                mb.attachFile(f);
                mp.addBodyPart(mb);
                mp.addBodyPart(mb2);

            }catch (Exception e) {
                throw new RuntimeException(e);

            }
            msg.setContent(mp);
            Transport.send(msg);
            System.out.println("mail send successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
