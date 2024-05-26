package com.assignment.question.services;

import com.assignment.question.Observer;
import com.assignment.question.utils.NotificationUtils;

// The TemperatureService class is a concrete observer that sends notifications when the temperature changes.
public class TemperatureService implements Observer {
    @Override
    public void notifyObserver(double value) {
        NotificationUtils.sendNotification("New value is " + value); // Sends a notification about the new value
    }
}
