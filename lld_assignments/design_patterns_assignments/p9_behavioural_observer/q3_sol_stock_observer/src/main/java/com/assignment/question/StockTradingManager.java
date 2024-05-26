package com.assignment.question;

import com.assignment.question.services.AppService;
import com.assignment.question.services.EmailService;
import com.assignment.question.services.SmsService;

// The StockTradingManager class extends the Publisher abstract class and represents a subject in the Observer Pattern.
public class StockTradingManager extends Publisher {

    private String stockName; // The name of the stock
    private double currentPrice; // The current price of the stock
    private double notificationThreshold; // The price threshold for sending notifications

    public StockTradingManager(String stockName, double initialPrice, double notificationThreshold) {
        this.stockName = stockName;
        this.currentPrice = initialPrice;
        this.notificationThreshold = notificationThreshold;
    }

    public void updateStockPrice(double newPrice) {
        currentPrice = newPrice; // Updates the current price
        if (currentPrice > notificationThreshold) {
            notifyObservers(stockName, currentPrice); // If the current price is greater than the notification threshold, notifies all observers
        }
    }
}

/*
    In this code, the Observer interface defines operations that all concrete observers must implement. The AppService, EmailService, and SmsService classes are concrete observers that send push, email, and SMS notifications, respectively. They implement the Observer interface and provide their own implementations of the notifyObserver method. The ObserverRegistry interface defines operations for managing observers. The Publisher abstract class implements the ObserverRegistry interface and provides a default implementation for managing observers. The StockTradingManager class extends the Publisher abstract class and represents a subject in the Observer Pattern. It maintains a list of observers and notifies them when the stock price changes.

    This is a classic implementation of the Observer Pattern. It is a behavioral design pattern that enables an object, called the subject, to maintain a list of its dependents, called observers, and notify them automatically of any state changes.
 */
