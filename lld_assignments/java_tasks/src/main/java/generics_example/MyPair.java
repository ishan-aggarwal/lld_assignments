package generics_example;

import java.util.HashMap;
import java.util.Map;

public class MyPair<F, S> {
    F first;
    S second;

    MyPair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    static <F, S> void doSomething(F f, S s) {
        System.out.print(f + " ");
        System.out.println(s);
    }


    public static void main(String[] args) {
        MyPair<Integer, Integer> pair1 = new MyPair<>(10, 20);
        Integer first1 = pair1.getFirst();
        Integer second1 = pair1.getSecond();
        System.out.println(first1 + " " + second1);


        MyPair<String, Double> pair2 = new MyPair<>("String", 20.0);
        String pair2First = pair2.getFirst();
        Double pair2Second = pair2.getSecond();
        System.out.println(pair2First + " " + pair2Second);

        MyPair<String, Map<String, Integer>> pair3 = new MyPair<>("String", new HashMap<>());
        String pair3First = pair3.getFirst();
        Map<String, Integer> pair3Second = pair3.getSecond();
        System.out.println(pair3First + " " + pair3Second);

        MyPair.doSomething(10, "Hello");
    }
}
