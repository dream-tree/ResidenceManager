package com.marcin.residence.account.message;

public class TestEmail {

    public static void main(String[] args) {
        EmailService emailService = new EmailService("smtp.gmail.com", 587, "***", "***");     
    }
}
