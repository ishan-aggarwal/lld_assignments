package com.assignment.question;

import com.assignment.question.notification.Notification;
import com.assignment.question.sender.NotificationSender;
import com.assignment.question.template.NotificationTemplate;

public abstract class NotificationFactory {

    public abstract NotificationType notificationType();

    public abstract Notification notification(String recipient, String sender, NotificationTemplate template);

    public abstract NotificationSender notificationSender(Notification notification);

    public abstract NotificationTemplate notificationTemplate(String message);


}

/*

The design pattern used here is the Abstract Factory Pattern. This pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes.

In this code, the NotificationFactory class is an abstract factory class that declares methods for creating different parts of a notification system (Notification, NotificationTemplate, and NotificationSender) and a method for getting the type of notification the factory supports. The EmailNotificationFactory and PushNotificationFactory classes are concrete factory classes that implement these methods to create email and push notifications, respectively.

This is a classic implementation of the Abstract Factory Pattern. The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. This pattern separates the details of implementation of a set of objects from their general usage and relies on object composition: object creation methods are implemented in methods exposed in the factory interface.
 */