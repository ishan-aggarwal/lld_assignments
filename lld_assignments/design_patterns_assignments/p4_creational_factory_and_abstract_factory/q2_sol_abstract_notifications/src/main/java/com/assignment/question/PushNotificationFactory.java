package com.assignment.question;

import com.assignment.question.notification.Notification;
import com.assignment.question.notification.PushNotification;
import com.assignment.question.sender.NotificationSender;
import com.assignment.question.sender.PushNotificationSender;
import com.assignment.question.template.NotificationTemplate;
import com.assignment.question.template.PushNotificationTemplate;

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }

    @Override
    public Notification notification(String recipient, String sender, NotificationTemplate template) {
        return new PushNotification(recipient, template);
    }

    @Override
    public NotificationSender notificationSender(Notification notification) {
        return new PushNotificationSender(notification);
    }

    @Override
    public NotificationTemplate notificationTemplate(String message) {
        return new PushNotificationTemplate(message);
    }
}