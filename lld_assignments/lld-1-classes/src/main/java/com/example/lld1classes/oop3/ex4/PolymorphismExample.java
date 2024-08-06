package com.example.lld1classes.oop3.ex4;

// method overloading
// compile time polymorphism
// static binding
public class PolymorphismExample {

    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    public int sum(float a, float b) {
        return (int) ((int) a + b);
    }

    public static void main(String[] args) {
        PolymorphismExample obj = new PolymorphismExample();
        System.out.println(obj.sum(2, 3));
        System.out.println(obj.sum(2, 3, 4));
        System.out.println(obj.sum(2.3f, 3.4f));
    }

}
