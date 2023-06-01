package lk.ijse.library.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) throws IOException {
        System.out.println("Giya");
        String to = "ishanravidu750@gmail.com"; // to address. It can be any like gmail, hotmail etc.
        final String from = "ishanravidu750@gmail.com"; // from address. As this is using Gmail SMTP.
        final String password = "urmzfdmvxrxgwubk"; // password for from mail address.
        System.out.println("Giya");
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        System.out.println("Giya");
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        System.out.println("Giya");
        try {
            System.out.println("awa");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Message from Java Simplifying Tech");

            String msg = "This email sent using JavaMailer API from Java Code!!!";
            System.out.println("awa");
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            System.out.println("awa");
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(new File("D:/mods/icons8-library-96.png"));
            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);
            System.out.println("awa");
            Transport.send(message);
            System.out.println("ssssss");
            System.out.println("Mail successfully sent..");

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
}
//        public static void main(String[] args)  {
//
//        System.out.println("Preparing to send email");
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.starttls.enable", true);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enabled", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//        String myAccountEmail = "ishanravidu750@gmail.com";
//        String password = "Ishan077@@";
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(myAccountEmail, password);
//            }
//        });
//        Message message = prepareMessage(session, myAccountEmail);
//        Transport.send(message);
//        System.out.println("Message sent successfully!");
//    }
//
//    private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(myAccountEmail));
//            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
//            message.setSubject("Welcome to the Library System");
//            message.setText("We are glad to have you on board with the Aquarium Management System.you are now able to manage your aquarium efficiently and easily.\nIf you have any questions or concerns, please feel free to reach out to us. Our team is always here to support you.\n\nBest regards,\nTeam Matrix");
//            return message;
//        } catch (Exception ex) {
//            System.out.println(SendMail.class.getName());
//        }
//        return null;
//    }
//}
