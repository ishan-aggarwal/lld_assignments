package com.assignment.question;

// The MomentumStrategy class is a concrete strategy for calculating the momentum trading indicator.
public class MomentumStrategy implements TradingIndicatorStrategy {
    @Override
    public TradingStrategyType supportsType() {
        return TradingStrategyType.MOMENTUM; // This strategy supports momentum trading
    }

    @Override
    public Double calculateIndicator(Stock stock) {
        return stock.getPrice() - stock.getPreviousPrice(); // The momentum is calculated as the difference between the current price and the previous price
    }
}
