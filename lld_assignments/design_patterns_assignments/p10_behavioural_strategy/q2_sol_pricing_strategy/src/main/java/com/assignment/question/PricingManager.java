package com.assignment.question;

// The design pattern used here is the Strategy Pattern. This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// Strategy lets the algorithm vary independently of clients that use it.
// The PricingManager class uses the Strategy Pattern to calculate the price of a ride.
public class PricingManager {

    public static final double BASE_FARE = 5.0; // Base fare amount
    private PricingStrategy pricingStrategy; // The strategy for calculating the price

    // Constructor for the PricingManager class
    public PricingManager(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    // The calculatePrice method calculates the price of the ride according to the strategy.
    public Double calculatePrice(RideDetails rideDetails) {
        return pricingStrategy.calculatePrice(rideDetails);
    }
}

/*
    In this code, the PricingStrategy interface defines operations that all concrete pricing strategies must implement.
    The DistanceBasedPricingStrategy, TimeBasedPricingStrategy, and SurgePricingStrategy classes are concrete strategies for calculating the price based on distance, time, and surge pricing, respectively.
    They implement the PricingStrategy interface and provide their own implementations of the supportsType and calculatePrice methods.
    The PricingManager class uses the Strategy Pattern to calculate the price of a ride.
    It maintains a reference to a PricingStrategy object and uses this object to calculate the price of a ride.

    This is a classic implementation of the Strategy Pattern.
    It is a behavioral design pattern that enables selecting an algorithm at runtime.
 */