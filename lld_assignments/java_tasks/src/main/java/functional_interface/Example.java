package functional_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        Test t1 = () ->
                System.out.println("Testing test functional interface");

        t1.test();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
        for (Integer element : list) {
            System.out.println(element);
        }

        list.forEach(System.out::println);

        List<Integer> count = list.stream().filter(element -> element > 2).toList();


        System.out.println(count);

        count.add(56);

        System.out.println(count);

    }
}
