package other;

public class SurgePricingStrategy implements PricingStrategy {
    private static final double BASE_FARE = 5.0;
    private static final double SURGE_MULTIPLIER = 1.5;

    @Override
    public double calculateFare(RideDetails rideDetails) {
        return BASE_FARE * SURGE_MULTIPLIER;
    }

    @Override
    public boolean supportsType(String type) {
        return "SURGE".equalsIgnoreCase(type);
    }
}