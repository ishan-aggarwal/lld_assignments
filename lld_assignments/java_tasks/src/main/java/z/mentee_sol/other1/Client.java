package z.mentee_sol.other1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ExecutorService sv1 = Executors.newFixedThreadPool(1);
        Future<ArrayList<Integer>> result = sv1.submit(new ArrayCreator(n));
        System.out.println(result.get());
        sv1.shutdown();
    }
}
