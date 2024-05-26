package com.assignment.question.utils;

public class NotificationUtils {
    public static void sendEmail(String subject, String content) {
        System.out.println("Sending email to: " + subject + " with content: " + content);
    }

    public static void sendSms(String subject, String content) {
        System.out.println("Sending SMS to: " + subject + " with content: " + content);
    }

    public static void sendPush(String subject, String content) {
        System.out.println("Sending push notification to: " + subject + " with content: " + content);
    }
}