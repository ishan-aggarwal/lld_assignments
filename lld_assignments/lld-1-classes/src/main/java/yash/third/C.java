package yash.third;

class A {

    public A() {
        System.out.println("Inside A");
    }

    public A(String msg) {
        System.out.println("Inside A constructor");
    }
}

class B extends A {
    public B() {
        System.out.println("Inside B");
    }

    public B(String msg) {
        super(msg);
        System.out.println("Inside B constructor");
    }
}

public class C extends B {

    public C() {
        this(""); // this can be used to call another constructor from the same class
        System.out.println("Inside c class const");
    }

    public C(String msg) {
        super(msg);
        System.out.println("Inside C constructor with message");
    }

    public static void main(String[] args) {
        C c = new C();
    }

}
