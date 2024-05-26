package com.assignment.question;

import static com.assignment.question.PricingManager.BASE_FARE;

// The SurgePricingStrategy class is a concrete strategy for calculating the price based on surge pricing.
public class SurgePricingStrategy implements PricingStrategy {
    private static final double SURGE_MULTIPLIER = 2.0; // Surge pricing multiplier

    @Override
    public PricingType supportsType() {
        return PricingType.SURGE; // This strategy supports surge pricing
    }

    @Override
    public Double calculatePrice(RideDetails rideDetails) {
        return BASE_FARE * SURGE_MULTIPLIER; // The price is calculated as the base fare times the surge multiplier
    }
}
