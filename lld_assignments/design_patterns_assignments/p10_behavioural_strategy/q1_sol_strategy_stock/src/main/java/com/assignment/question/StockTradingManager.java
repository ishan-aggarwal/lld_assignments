package com.assignment.question;

// The StockTradingManager class uses the Strategy Pattern to calculate the trading indicator of a stock.

// The design pattern used here is the Strategy Pattern. This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// Strategy lets the algorithm vary independently of clients that use it.
public class StockTradingManager {

    private TradingIndicatorStrategy indicatorStrategy; // The strategy for calculating the trading indicator

    // Constructor for the StockTradingManager class
    public StockTradingManager(TradingIndicatorStrategy indicatorStrategy) {
        this.indicatorStrategy = indicatorStrategy;
    }

    // The calculateIndicator method calculates the trading indicator of the stock according to the strategy.
    public Double calculateIndicator(Stock stock) {
        return indicatorStrategy.calculateIndicator(stock);
    }
}

/*
    In this code, the TradingIndicatorStrategy interface defines operations that all concrete trading indicator strategies must implement.
    MomentumStrategy, MovingAveragesStrategy, and VolatilityStrategy classes are concrete strategies for calculating the momentum, moving averages, and volatility trading indicators, respectively.
    They implement the TradingIndicatorStrategy interface and provide their own implementations of the supportsType and calculateIndicator methods. The StockTradingManager class uses the Strategy Pattern to calculate the trading indicator of a stock.
    It maintains a reference to a TradingIndicatorStrategy object and uses this object to calculate the trading indicator of a stock.
    This is a classic implementation of the Strategy Pattern. It is a behavioral design pattern that enables selecting an algorithm at runtime.
 */