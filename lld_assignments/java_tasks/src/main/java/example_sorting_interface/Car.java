package example_sorting_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Car implements Comparable<Car> {
    int price;
    int speed;
    String name;

    // Constructor
    public Car(int price, int speed, String name) {
        this.price = price;
        this.speed = speed;
        this.name = name;
    }

    // Implement the compareTo method to compare Cars by price
    @Override
    public int compareTo(Car otherCar) {
//        return otherCar.price - this.price;
        return this.name.compareTo(otherCar.name);
    }

    // Override toString method for better readability
    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", speed=" + speed +
                ", name=" + name +
                '}';
    }

    // Main method for testing
    public static void main(String[] args) {
        Car car1 = new Car(10000, 150, "A");
        Car car2 = new Car(8000, 140, "C");
        Car car3 = new Car(12000, 160, "B");

        Car[] cars = {car1, car2, car3};
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        System.out.println(carList);


        System.out.println("Before sorting:");
        for (Car car : cars) {
            System.out.println(car);
        }

        Arrays.sort(cars);
        Collections.sort(carList);

        System.out.println(carList);

        System.out.println("\nAfter sorting:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
