package yash.second;

import java.util.LinkedList;
import java.util.Queue;

public class FinalClassExample {

    int i = 0;
    static int j = 10;
// final is used with data variables (data members/ or class level variables) to ensure that there value can not change.
    final static int k = 15;

    // final.. is used to make constants
    // if final is used with a method - it means that you can not override that method
    // class A -> m1, final m2
    // class B extends A -> m1, m2 method can not be overridden in the child class because m2 is marked as final in base class

    // if final is used with a class - it means that it is final definition of the class and the class can not be extended
    void m1() {
        System.out.println("this is m1 method in class FinalClassExample");
    }
    void m2() {
        System.out.println("this is final definition of method m2 in the classFinalClassExample ");
    }


    public static void main(String[] args) {
        final int l = 50;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);

    }
}
