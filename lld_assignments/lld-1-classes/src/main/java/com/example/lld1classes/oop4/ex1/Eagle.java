package com.example.lld1classes.oop4.ex1;

public class Eagle extends Birds implements Flyable, Quackable {
    @Override
    public void eat() {
        System.out.println("Eagle is eating");
    }

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }

    @Override
    public void quack() {
        System.out.println("Eagle is doing kaww kawww");
    }
}
