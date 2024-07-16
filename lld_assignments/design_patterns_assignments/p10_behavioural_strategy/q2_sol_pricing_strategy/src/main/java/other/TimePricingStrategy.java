package other;

public class TimePricingStrategy implements PricingStrategy {
    private static final double BASE_FARE = 5.0;
    private static final double PER_MINUTE_RATE = 0.5;

    @Override
    public double calculateFare(RideDetails rideDetails) {
        return BASE_FARE + PER_MINUTE_RATE * rideDetails.getDuration();
    }

    @Override
    public boolean supportsType(String type) {
        return "TIME".equalsIgnoreCase(type);
    }
}