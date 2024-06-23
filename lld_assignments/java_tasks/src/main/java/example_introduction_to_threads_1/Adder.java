package example_introduction_to_threads_1;

public class Adder implements Runnable {

    int num1;
    int num2;

    Adder(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        System.out.println(num1 + num2);
    }
}