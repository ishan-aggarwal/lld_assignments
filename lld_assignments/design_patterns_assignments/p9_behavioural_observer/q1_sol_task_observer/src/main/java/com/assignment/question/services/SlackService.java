package com.assignment.question.services;

import com.assignment.question.utils.NotificationUtils;
import com.assignment.question.Observer;

// The SlackService class is a concrete observer that sends Slack notifications when a task is assigned.
public class SlackService implements Observer {
    @Override
    public void notifyObserver(Long taskId, Long userId) {
        String subject = "New task assigned";
        String message = "Task %s assigned to user %s";
        NotificationUtils.sendSlack(subject, String.format(message, taskId, userId)); // Sends a Slack notification
    }
}
