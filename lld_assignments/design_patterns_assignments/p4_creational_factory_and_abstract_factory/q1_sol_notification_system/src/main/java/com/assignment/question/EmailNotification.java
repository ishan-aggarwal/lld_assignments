package com.assignment.question;

// Concrete class for an email notification
public class EmailNotification extends Notification {
    private final String sender;

    // Constructor for the EmailNotification class
    public EmailNotification(String recipient, String sender, String message) {
        super(recipient, message);
        this.sender = sender;
    }

    // Getter for the sender attribute
    public String getSender() {
        return sender;
    }

    // Method for sending the email notification
    @Override
    public void sendNotification() {
        System.out.println("Email sent to " + getRecipient() + " from " + sender);
        System.out.println("Message: " + getMessage());
    }

    // Method for getting the type of notification
    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }
}
