package com.assignment.question;

import static com.assignment.question.PricingManager.BASE_FARE;

// The TimeBasedPricingStrategy class is a concrete strategy for calculating the price based on time.
public class TimeBasedPricingStrategy implements PricingStrategy {

    private static final double PER_MINUTE_RATE = 0.5; // Rate per minute

    @Override
    public PricingType supportsType() {
        return PricingType.TIME_BASED; // This strategy supports time-based pricing
    }

    @Override
    public Double calculatePrice(RideDetails rideDetails) {
        return BASE_FARE + PER_MINUTE_RATE * rideDetails.getDuration(); // The price is calculated as the base fare plus the rate per minute times the duration
    }
}

