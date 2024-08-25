package yash.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClientClass {

    public static void main(String[] args) {

        // Programming to an interface and not to an implementation
        TestInterface myObject = new TestInterfaceImpl();
        myObject.method();


        Addition ad = new Addition(1, 2);
        ad.defaultVariable = 10;


        Addition.staticVariable = 20;

        int sum = Addition.sum(10, 20);
        System.out.println(sum);

        // run-time polymorphism
        // dynamic binding
        myObject = new TestIntefaceImpl1();
        myObject.method();

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        System.out.println(list);
//
//        list = new LinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        // Top Level Type -> Bank
//        // CitiBank implements Bank
//        // Citibank -> AxisBank

    }
}
