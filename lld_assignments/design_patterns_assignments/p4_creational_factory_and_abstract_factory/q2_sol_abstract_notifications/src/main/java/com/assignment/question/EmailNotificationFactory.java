package com.assignment.question;

import com.assignment.question.notification.EmailNotification;
import com.assignment.question.notification.Notification;
import com.assignment.question.sender.EmailNotificationSender;
import com.assignment.question.sender.NotificationSender;
import com.assignment.question.template.EmailNotificationTemplate;
import com.assignment.question.template.NotificationTemplate;

public class EmailNotificationFactory extends NotificationFactory {

    @Override
    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }

    @Override
    public Notification notification(String recipient, String sender, NotificationTemplate template) {
        return new EmailNotification(recipient, sender, template);
    }

    @Override
    public NotificationSender notificationSender(Notification notification) {
        return new EmailNotificationSender(notification);
    }

    @Override
    public NotificationTemplate notificationTemplate(String message) {
        return new EmailNotificationTemplate(message);
    }
}