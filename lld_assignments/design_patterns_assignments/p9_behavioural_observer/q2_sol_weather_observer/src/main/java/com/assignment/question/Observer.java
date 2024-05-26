package com.assignment.question;

// The Observer interface defines operations that all concrete observers must implement.
public interface Observer {
    void notifyObserver(double value); // Notifies the observer about a change in value
}