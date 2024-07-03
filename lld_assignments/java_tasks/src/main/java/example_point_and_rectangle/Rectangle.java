package example_point_and_rectangle;

public class Rectangle {
    // write the code of Rectangle class here
    Point topLeft;
    Point bottomRight;

    public Rectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        this.topLeft = new Point(topLeftX, topLeftY);
        this.bottomRight = new Point(bottomRightX, bottomRightY);
    }

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = new Point(topLeft);
        this.bottomRight = new Point(bottomRight);
    }

    public Rectangle(Rectangle copyR) {
        this.topLeft = new Point(copyR.topLeft);
        this.bottomRight = new Point(copyR.bottomRight);
    }
}