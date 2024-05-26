package com.assignment.question;

// The ObserverRegistry interface defines operations for managing observers.
public interface ObserverRegistry {
    void addObserver(Observer observer); // Adds an observer

    void removeObserver(Observer observer); // Removes an observer

    void notifyObservers(Long taskId, Long userId); // Notifies all observers about a task assignment
}
