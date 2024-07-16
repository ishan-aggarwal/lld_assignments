package other;

public interface PricingStrategy {
    double calculateFare(RideDetails rideDetails);

    boolean supportsType(String type); // Add this method if it is required
}




