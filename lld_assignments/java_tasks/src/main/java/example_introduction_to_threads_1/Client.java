package example_introduction_to_threads_1;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        Adder ad = new Adder(num1, num2);
        ScalerThread t = new ScalerThread(ad);
        t.start();
    }
}
