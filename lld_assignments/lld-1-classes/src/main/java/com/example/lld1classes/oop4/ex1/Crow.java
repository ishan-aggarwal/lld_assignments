package com.example.lld1classes.oop4.ex1;

public class Crow extends Birds implements Flyable {
    @Override
    public void eat() {
        System.out.println("Crow is eating");
    }

    @Override
    public void fly() {
        System.out.println("Crow is flying");
    }
}
