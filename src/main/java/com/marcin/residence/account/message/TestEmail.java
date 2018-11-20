package com.marcin.residence.account.message;

/**
 * Temporary test class for an email service.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public class TestEmail {

    public static void main(String[] args) {
        EmailService emailService = new EmailService("smtp.gmail.com", 587, "***", "***");
    }
}
