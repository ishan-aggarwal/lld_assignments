package com.assignment.question;

// Concrete class for an SMS notification
public class SmsNotification extends Notification {
    // Constructor for the SmsNotification class
    public SmsNotification(String recipient, String message) {
        super(recipient, message);
    }

    // Method for sending the SMS notification
    public void sendNotification() {
        System.out.println("SMS sent to " + getRecipient());
        System.out.println("Message: " + getMessage());
    }

    // Method for getting the type of notification
    public NotificationType notificationType() {
        return NotificationType.SMS;
    }
}
