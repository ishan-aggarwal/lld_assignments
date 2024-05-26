package com.assignment.question;

// The Observer interface defines operations that all concrete observers must implement.
public interface Observer {
    void notifyObserver(Long taskId, Long userId); // Notifies the observer about a task assignment
}
