package com.assignment.question;

import static com.assignment.question.PricingManager.BASE_FARE;

// The DistanceBasedPricingStrategy class is a concrete strategy for calculating the price based on distance.
public class DistanceBasedPricingStrategy implements PricingStrategy {

    private static final double PER_KILOMETER_RATE = 2.0; // Rate per kilometer

    @Override
    public PricingType supportsType() {
        return PricingType.DISTANCE_BASED; // This strategy supports distance-based pricing
    }

    @Override
    public Double calculatePrice(RideDetails rideDetails) {
        return BASE_FARE + PER_KILOMETER_RATE * rideDetails.getDistance(); // The price is calculated as the base fare plus the rate per kilometer times the distance
    }
}
