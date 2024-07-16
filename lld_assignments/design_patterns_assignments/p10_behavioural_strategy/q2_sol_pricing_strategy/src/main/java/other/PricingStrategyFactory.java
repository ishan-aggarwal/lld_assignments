package other;

public class PricingStrategyFactory {
    public PricingStrategy getPricingStrategy(String strategyType) {
        switch (strategyType) {
            case "Distance":
                return new DistancePricingStrategy();
            case "Time":
                return new TimePricingStrategy();
            case "Surge":
                return new SurgePricingStrategy();
            default:
                throw new IllegalArgumentException("Unknown strategy type");
        }
    }
}




