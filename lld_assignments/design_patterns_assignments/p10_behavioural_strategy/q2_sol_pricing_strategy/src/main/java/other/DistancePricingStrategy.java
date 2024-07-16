package other;

public class DistancePricingStrategy implements PricingStrategy {
    private static final double BASE_FARE = 5.0;
    private static final double PER_KILOMETER_RATE = 2.0;

    @Override
    public double calculateFare(RideDetails rideDetails) {
        return BASE_FARE + PER_KILOMETER_RATE * rideDetails.getDistance();
    }

    @Override
    public boolean supportsType(String type) {
        return "DISTANCE".equalsIgnoreCase(type);
    }
}











