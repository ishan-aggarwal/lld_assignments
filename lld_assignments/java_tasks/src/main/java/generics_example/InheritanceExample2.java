package generics_example;

import java.util.ArrayList;
import java.util.List;

public class InheritanceExample2 {
    static void doSomething(List<Animal> animals) {
        System.out.println(animals);
    }

    static void doSomething1(List<? super Dog> animals) {
        System.out.println(animals);
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Casper"));
//        doSomething(dogs);
        doSomething1(dogs);

        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("My dog 1"));
        doSomething1(animals);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("mycat-1"));
//        doSomething1(cats);
    }
}
