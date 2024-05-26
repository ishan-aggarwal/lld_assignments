package question.services;

import question.Observer;
import question.utils.NotificationUtils;

// The AppService class is a concrete observer that sends push notifications when a task is assigned.
public class AppService implements Observer {
    @Override
    public void notifyObserver(Long taskId, Long userId) {
        String subject = "New task assigned";
        String message = "Task %s assigned to user %s";
        NotificationUtils.sendPush(subject, String.format(message, taskId, userId)); // Sends a push notification
    }
}
