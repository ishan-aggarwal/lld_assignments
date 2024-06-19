package generics_example;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}

@ToString(callSuper = true)
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

@ToString(callSuper = true)
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

public class InheritanceExample {
    static void doSomething(List<Animal> animals) {
        System.out.println(animals);
    }

    static void doSomething1(List<? extends Animal> animals) {
        System.out.println(animals);
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Casper"));
//        doSomething(dogs);
        doSomething1(dogs);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("mycat-1"));
        doSomething1(cats);
    }
}
