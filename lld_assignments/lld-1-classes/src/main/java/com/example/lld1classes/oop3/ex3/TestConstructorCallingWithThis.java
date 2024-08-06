package com.example.lld1classes.oop3.ex3;

class A {
    public A() {
        this(10);
        System.out.println("Inside A default constructor");
    }

    public A(int x) {
        this(x, 100);
        System.out.println("Inside A 1 argument constructor with x: " + x);
    }

    public A(int x, int y) {
        System.out.println("Inside A 2 argument constructor with x: " + x
                + " and y: " + y);
    }
}

public class TestConstructorCallingWithThis {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println("Main program ended");
    }
}
