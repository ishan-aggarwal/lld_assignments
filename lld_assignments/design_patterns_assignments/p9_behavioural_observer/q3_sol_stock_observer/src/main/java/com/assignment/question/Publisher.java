package com.assignment.question;

import java.util.ArrayList;
import java.util.List;

// The Publisher abstract class implements the ObserverRegistry interface and provides a default implementation for managing observers.
public abstract class Publisher implements ObserverRegistry {

    private List<Observer> observers = new ArrayList<>(); // The list of observers

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer); // Adds an observer to the list
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer); // Removes an observer from the list
    }

    @Override
    public void notifyObservers(String stockName, double currentPrice) {
        observers.forEach(observer -> observer.notifyObserver(stockName, currentPrice)); // Notifies all observers about a change in the stock price
    }
}
