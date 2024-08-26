package yash.third;

import java.io.File;
import java.util.*;

public class GenericsExample {


    public static void main(String[] args) {

        // raw type - it does not have type...
        List list = new ArrayList<>();
        list.add("Str");
        list.add(1);
        list.add(2.3f);

        // It may result into class cast exception.. runtime -> it is more problematic
        for (int i = 0; i < list.size(); i++) {
//            String element = (String) list.get(i);
//            System.out.println(element);
        }

        // Generics - same class List can be used to hold different types of data
        // List -> collection -> which is nothing but a group of similar objects...
        List<String> list1 = new ArrayList<>();
        list1.add("String");

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);

        Map<String, String> map = new LinkedHashMap<>();
        list2 = null;

        int[] arr = new int[10];
        System.out.println(arr[12]); //ArrayIndexOutOfbound exception

        int a = 10 / 0; // DivideByZeroException

//        System.out.println(list2.size()); // unchecked exception

        // checked exceptions


        Runnable r = () -> System.out.println("Hello world");
        Thread t1 = new Thread(r);

        t1.start();


        // Exception handling ->
        // is must for checked exceptions...s
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }

        // Checked and Unchecked
        // Exception ->

        // RunTimeException ->


        Box<String> box = new Box<>();
        box.addContent("String");
        System.out.println(box.getContent());

        Box<Integer> box1 = new Box<>();
        box1.addContent(1);
        System.out.println(box1.getContent());

    }
}
