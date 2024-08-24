package z.mentee_sol.other;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class ArrayCreator implements Callable<List<Integer>> {

    int n;
    List<Integer> l;

    ArrayCreator(int n) {
        this.n = n;
        this.l = new ArrayList<>();
    }

    @Override
    public List<Integer> call() throws Exception {
        for (int i = 1; i <= n; i++) {
            this.l.add(i);
        }
        return this.l;
    }
}

class Client {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ExecutorService es = Executors.newSingleThreadExecutor();
        ArrayCreator arr = new ArrayCreator(n);
        Future<List<Integer>> ans = es.submit(arr);
        List<Integer> list = ans.get();
        System.out.println(list);

    }
}