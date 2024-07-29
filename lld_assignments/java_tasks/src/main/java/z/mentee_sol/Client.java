package z.mentee_sol;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

//A -> B -> C

// A a = new B();
// B b = new C();

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Callable arrayCreator = new ArrayCreator(number);

        FutureTask<ArrayList<Integer>> futureTask = new FutureTask<>(arrayCreator);
        Thread thread = new Thread(futureTask);
        thread.start();

        ArrayList<Integer> list = futureTask.get();
        /*
        for(int num : list){
            System.out.print(num + ', ');
        }
        */
        String listToString = list.toString();
        System.out.println(listToString);
    }
}