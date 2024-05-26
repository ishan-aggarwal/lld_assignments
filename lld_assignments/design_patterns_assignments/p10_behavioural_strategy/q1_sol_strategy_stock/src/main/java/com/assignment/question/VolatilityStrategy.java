package com.assignment.question;

// The VolatilityStrategy class is a concrete strategy for calculating the volatility trading indicator.
public class VolatilityStrategy implements TradingIndicatorStrategy {
    @Override
    public TradingStrategyType supportsType() {
        return TradingStrategyType.VOLATILITY; // This strategy supports volatility trading
    }

    @Override
    public Double calculateIndicator(Stock stock) {
        return Math.abs(stock.getPrice() - stock.getPreviousPrice()); // The volatility is calculated as the absolute difference between the current price and the previous price
    }
}
