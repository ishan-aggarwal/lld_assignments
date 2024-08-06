package com.example.lld1classes.oop3.ex2;

class A {
    public A() {
        System.out.println("In class A constructor");
    }

    public A(int x) {
        System.out.println("In class A constructor with x: " + x);
    }
}

class B extends A {
    public B() {
        super(100);
        System.out.println("In class B constructor");
    }
}


class C extends B {
    public C() {
        System.out.println("In class C constructor");
    }
}

public class TestHierarchyWithSuper {

    public static void main(String[] args) {
        C obj = new C();
        System.out.println("Main program ended");
    }
}
