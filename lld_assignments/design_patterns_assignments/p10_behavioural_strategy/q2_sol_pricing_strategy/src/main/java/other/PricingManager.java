package other;

public class PricingManager {
    public static final double BASE_FARE = 5.0; // Base fare amount
    private PricingStrategy pricingStrategy; // The strategy for calculating the price

    // Constructor for the PricingManager class
    public PricingManager(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    // The calculatePrice method calculates the price of the ride according to the strategy.
    public Double calculatePrice(RideDetails rideDetails) {
        return pricingStrategy.calculateFare(rideDetails);
    }
}




