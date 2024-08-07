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

    public static void main(String[] args) {
        Point tL = new Point(1, 2);
        Point bR = new Point(4, 5);

        Point copyPoint = new Point(tL);

        Rectangle r = new Rectangle(tL, bR);

        Rectangle r1 = new Rectangle(r);
        System.out.println("hello");
    }
}