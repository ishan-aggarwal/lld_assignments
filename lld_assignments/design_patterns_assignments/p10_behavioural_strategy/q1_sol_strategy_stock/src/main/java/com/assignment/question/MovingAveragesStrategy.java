package com.assignment.question;

// The MovingAveragesStrategy class is a concrete strategy for calculating the moving averages trading indicator.
public class MovingAveragesStrategy implements TradingIndicatorStrategy {
    @Override
    public TradingStrategyType supportsType() {
        return TradingStrategyType.MOVING_AVERAGES; // This strategy supports moving averages trading
    }

    @Override
    public Double calculateIndicator(Stock stock) {
        return (stock.getPrice() + stock.getPreviousPrice()) / 2; // The moving average is calculated as the average of the current price and the previous price
    }
}
