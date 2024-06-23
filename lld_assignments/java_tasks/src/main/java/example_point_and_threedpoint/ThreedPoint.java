package example_point_and_threedpoint;

public class ThreedPoint extends Point {
    // write the code of ThreedPoint class here
    private int z;

    @Override
    public void display() {
        System.out.println("[" + x + ", " + y + ", " + z + "]");
    }
}