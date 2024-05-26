package com.assignment.question;

public interface TradingIndicatorStrategy {
    TradingStrategyType supportsType();

    Double calculateIndicator(Stock stock); // Calculates the trading indicator based on the stock
}