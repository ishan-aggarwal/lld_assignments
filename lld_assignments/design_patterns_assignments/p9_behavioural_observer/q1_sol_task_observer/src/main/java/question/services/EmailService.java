package question.services;


import question.Observer;
import question.utils.NotificationUtils;

// The EmailService class is a concrete observer that sends email notifications when a task is assigned.
public class EmailService implements Observer {

    @Override
    public void notifyObserver(Long taskId, Long userId) {
        String subject = "New task assigned";
        String message = "Task %s assigned to user %s";
        NotificationUtils.sendEmail(subject, String.format(message, taskId, userId)); // Sends an email notification
    }
}
