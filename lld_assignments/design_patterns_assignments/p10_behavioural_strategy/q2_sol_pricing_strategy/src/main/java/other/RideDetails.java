package other;

public class RideDetails {
    private double duration;
    private double distance;

    public RideDetails(double duration, double distance) {
        this.duration = duration;
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public double getDistance() {
        return distance;
    }
}