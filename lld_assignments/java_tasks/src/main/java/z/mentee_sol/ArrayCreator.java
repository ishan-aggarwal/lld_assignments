package z.mentee_sol;

import java.util.concurrent.Callable;
import java.util.*;

public class ArrayCreator implements Callable<ArrayList<Integer>> {
    public int number;

    public ArrayCreator(int number) {
        this.number = number;
    }

    public ArrayList<Integer> call() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            list.add(i);
        }
        return list;
    }
}