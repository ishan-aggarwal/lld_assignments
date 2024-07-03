package example_point_and_rectangle;

public class Point {
    // write the code of point class here
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(Point copy) {
        this.x = copy.x;
        this.y = copy.y;
    }
}
