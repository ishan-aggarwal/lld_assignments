package example_sorting_interface;

import java.util.Arrays;

public class Car implements Comparable<Car> {
    int price;
    int speed;

    // Constructor
    public Car(int price, int speed) {
        this.price = price;
        this.speed = speed;
    }

    // Implement the compareTo method to compare Cars by price
    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(this.price, otherCar.price);
    }

    // Override toString method for better readability
    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", speed=" + speed +
                '}';
    }

    // Main method for testing
    public static void main(String[] args) {
        Car car1 = new Car(10000, 150);
        Car car2 = new Car(8000, 140);
        Car car3 = new Car(12000, 160);

        Car[] cars = {car1, car2, car3};

        System.out.println("Before sorting:");
        for (Car car : cars) {
            System.out.println(car);
        }

        Arrays.sort(cars);

        System.out.println("\nAfter sorting:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
