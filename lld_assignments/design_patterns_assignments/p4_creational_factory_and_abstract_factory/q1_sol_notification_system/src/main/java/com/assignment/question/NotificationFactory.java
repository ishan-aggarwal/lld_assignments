package com.assignment.question;

// Factory class for creating notifications
public class NotificationFactory {
    // Factory method for creating the appropriate notification based on the notification type
    public static Notification createNotification(NotificationType notificationType, String recipient, String message, String sender) {
        return switch (notificationType) {
            case EMAIL -> new EmailNotification(recipient, sender, message);
            case SMS -> new SmsNotification(recipient, message);
            case PUSH -> new PushNotification(recipient, message);
            default -> throw new IllegalArgumentException("Invalid notification type");
        };
    }
}
/*
The design pattern used here is the Factory Method Pattern. The Factory Method Pattern is a creational pattern as it defines and describes how to realize different families of objects. This pattern provides an interface for creating objects, but allows subclasses to alter the type of objects that will be created.
 */