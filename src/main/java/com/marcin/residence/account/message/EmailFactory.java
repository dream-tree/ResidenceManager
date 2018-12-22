package com.marcin.residence.account.message;

import java.math.BigDecimal;
import java.util.Map;
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
 * @version 5.00, September-December 2018
 *
 */
public class EmailFactory {

    private String host = "";
    private int port = 0;
    private String username = "";
    private String password = "";
    private Logger logger = Logger.getLogger(getClass().getName());

    public EmailFactory(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public void sendMail(Map<Integer, BigDecimal> apartmentsWithOverdrafts,
            Map<Integer, String> apartmentsWithEmails) {
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
            message.setSubject("Demand for Payment");
            System.out.println("111");
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            for (Integer apartmentId : apartmentsWithEmails.keySet()) {
                String emailAddress = apartmentsWithEmails.get(apartmentId);
                BigDecimal overdraft = apartmentsWithOverdrafts.get(apartmentId);
                System.out.println("222");
                StringBuilder htmlMessage = new StringBuilder();
                htmlMessage
                        .append("<h3>Dear Owner,</h3>")
                        .append("<p>We appreciate your business. However, ")
                        .append("it has recently come to our attention that ")
                        .append("your account is overdue in the amount of PLN")
                        .append(overdraft)
                        .append(". Please remit payment to avoid any late fees.</p>")
                        .append("<p>Thank you.</p>")
                        .append("<p>Yours Truly Residence Management Team.</p>");
                mimeBodyPart.setContent(htmlMessage.toString(), "text/html");
                System.out.println("333");
                System.out.println(htmlMessage);
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(emailAddress));
                System.out.println("444");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(mimeBodyPart);
                System.out.println("555");
                message.setContent(multipart);
                System.out.println("666");
                Transport.send(message);
                System.out.println("777");
            }
        } catch (Exception ex) {
            logger.info(">> EmailService#sendMail: " + ex.getMessage());
            logger.info(">> EmailService#sendMail: " + ex.getStackTrace());
        }
    }
}