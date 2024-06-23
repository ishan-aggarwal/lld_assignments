package example_introduction_to_threads_2;

public class Adder implements Runnable {
    @Override
    public void run() {
        System.out.println("I am the Adder class");
    }
}