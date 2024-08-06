package com.example.lld1classes.oop3.ex1;

class A {
    public A() {
        System.out.println("In class A constructor");
    }
}

class B extends A {
    public B() {
        System.out.println("In class B constructor");
    }
}


class C extends B {
    public C() {
        System.out.println("In class C constructor");
    }
}

public class TestHierarchy {

    public static void main(String[] args) {
        C obj = new C();
        System.out.println("Main program ended");
    }
}
