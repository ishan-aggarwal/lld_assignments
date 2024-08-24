package streaming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
}

public class TestExample {

    public static void main(String[] args) {

        List<Integer> listABC = new ArrayList<>();
        listABC.add(1);
        listABC.add(2);
        listABC.add(3);

        // method reference operator
//        listABC.forEach(System.out.println());

        listABC.forEach(e -> System.out.println(e));

        System.out.println("-------------------------------------------------------------");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
                System.out.println("hello world1");
            }
        };
        Thread t = new Thread(runnable);
        t.start();

        Runnable r = () -> {
            System.out.println("Hello World");
            System.out.println("hello world1");
        };
        Thread t1 = new Thread(r);
        t1.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread t2 = new Thread(myRunnable);
        t2.start();

        MyThread t4 = new MyThread();
        t4.start();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        List<Integer> answer = new ArrayList<>();
        for (int num : list) {
            if (num % 2 == 0) {
                answer.add(num * num);
            }
        }
        System.out.println(answer);

        List<Integer> streamAnswer =
                list.stream()
                        .filter(getIntegerPredicate())
                        .map(n -> n * n)
                        .collect(Collectors.toList());

        Stream<Integer> stream = list.stream();

        List<Integer> list1 = stream.filter(getIntegerPredicate())
                .map(n -> n * n)
                .toList();
//
//        List<Integer> list2 = stream.filter(n -> n % 2 == 0)
//                .map(n -> n * n)
//                .toList();


        // starting operators .stream()
        // intermediate operations  .filter(n -> n % 2 == 0) .map(n -> n * n)
        // terminal operations .toList();

        list1.forEach(System.out::println);

        // System.out
        // System
        // public static PrintStream out;
        // PrintStream out

        System.out.println(streamAnswer);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
//
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        int[] arr = {1, 2, 3, 4, 5};
        Map<Integer, Integer> myMap =
                Arrays.stream(arr)
                        .boxed()
                        .filter(ele -> ele % 2 == 0)
                        .map(ele -> ele * 3)
//                        .toList();
                        .collect(Collectors.toMap(n -> n, n -> n * n));

//        Set<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);

//        for (Integer ele : set.)

    }

    private static Predicate<Integer> getIntegerPredicate() {
        return n -> n % 2 == 0;
    }
}
