package z.ex2;

class A {
    void sum(int a, int b) {
        System.out.println("A's sum(int, int): " + (a + b));
    }
}

class B extends A {
    void sum(int a, long b) {
        System.out.println("B's sum(int, long): " + (a + b));
    }
}

public class Child {
    public static void main(String[] args) {
        B obj = new B();
        obj.sum(10, 20);         // Calls A's sum(int, int)
        obj.sum(10, 20L);        // Calls B's sum(int, long)
    }
}
