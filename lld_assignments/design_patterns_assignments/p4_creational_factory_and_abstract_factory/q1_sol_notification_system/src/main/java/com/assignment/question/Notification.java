package com.assignment.question;

// Abstract class for a notification
public abstract class Notification {
    private final String recipient;
    private final String message;

    // Constructor for the Notification class
    public Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    // Getters for the Notification class attributes
    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    // Abstract methods for the Notification class
    public abstract NotificationType notificationType();

    public abstract void sendNotification();
}

/*

In this code, the Notification class is an abstract class that declares methods for sending a notification and getting the type of notification. The NotificationFactory class is a factory class that has a factory method createNotification for creating the appropriate Notification based on the NotificationType. The EmailNotification, PushNotification, and SmsNotification classes are concrete classes that implement these methods to send email, push, and SMS notifications, respectively.

This is a classic implementation of the Factory Method Pattern. This pattern separates the details of implementation of a set of objects from their general usage and relies on object composition: object creation methods are implemented in methods exposed in the factory interface.
 */