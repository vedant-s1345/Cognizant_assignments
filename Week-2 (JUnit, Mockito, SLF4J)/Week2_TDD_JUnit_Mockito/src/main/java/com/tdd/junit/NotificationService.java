package com.tdd.junit;

public class NotificationService {

    public void sendNotification(String message) {
        // In real life this would send an email/SMS
        System.out.println("Sending notification: " + message);
    }

    public void sendEmail(String to, String subject) {
        System.out.println("Sending email to: " + to + " | Subject: " + subject);
    }
}