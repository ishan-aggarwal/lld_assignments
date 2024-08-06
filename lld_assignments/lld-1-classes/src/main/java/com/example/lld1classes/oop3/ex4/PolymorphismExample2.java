package com.example.lld1classes.oop3.ex4;

// Method overriding
// run time polymorphism
// dynamic binding
class A {

    protected int field = 20;

    public void get() {
        System.out.println("Inside get method of A");
    }

    public static void test() {
        System.out.println("Inside static test method of class A");
    }
}

class B extends A {

    public int field = 100;
    @Override
    public void get() {
        System.out.println("Inside get method of B");
    }

    public static void test() {
        System.out.println("Inside static test method of class B");
    }
}

public class PolymorphismExample2 {
    public static void main(String[] args) {
        A a = new A();
        a.get(); // Inside get method of A
        System.out.println(a.field); // 20
        a.test();

        A b = new B();
        b.get(); // Inside get method of B
        System.out.println(b.field); // 20
        b.test();

        B b1 = new B();
        b1.get(); // Inside get method of B
        System.out.println(b1.field); // 100
        b1.test();

        // method will check the object that is created at runtime and will be called based on that
        // while properties check the reference which is on the left side at compile time and that will be used.
        // while static method also check the reference which is on the left side at compile time and that will be used.
    }

}
