package com.assignment.question;

// Concrete class for a push notification
public class PushNotification extends Notification {
    // Constructor for the PushNotification class
    public PushNotification(String recipient, String message) {
        super(recipient, message);
    }

    // Method for sending the push notification
    public void sendNotification() {
        System.out.println("Push notification sent to device " + getRecipient());
        System.out.println("Message: " + getMessage());
    }

    // Method for getting the type of notification
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}
