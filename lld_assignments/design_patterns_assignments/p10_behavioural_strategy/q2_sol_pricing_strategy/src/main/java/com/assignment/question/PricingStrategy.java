package com.assignment.question;

// The PricingStrategy interface defines operations that all concrete pricing strategies must implement.
public interface PricingStrategy {
    PricingType supportsType(); // Returns the type of pricing the strategy supports

    Double calculatePrice(RideDetails rideDetails); // Calculates the price based on the ride details
}