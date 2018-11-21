package com.marcin.residence.account.message;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Provides an email service for sending messages to apartment owners.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 *
 * TODO
 */
public class EmailService {

    private String host = "";
    private int port = 0;
    private String username = "";
    private String password = "";  
    private Logger logger = Logger.getLogger(getClass().getName());

    public EmailService(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        sendMail();
    }

    private void sendMail() {
        Properties property = new Properties();
        property.put("mail.smtp.auth", true);
        property.put("mail.smtp.starttls.enable", "true");
        property.put("mail.smtp.host", host);
        property.put("mail.smtp.port", port);
        property.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(property, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("***"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("***"));
            message.setSubject("Test message");

            String msg = "Testing email service.";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html");

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(new File("pom.xml"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);

            Transport.send(message);

        } catch (Exception ex) {
            logger.info(">> EmailService#sendMail: " + ex.getMessage());
        }
    }
}