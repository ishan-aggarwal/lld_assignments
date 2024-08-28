package yash.fourth_threading;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Inside the run method.");
        try {
            Thread.sleep(2000); //2000 millieseconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The run method has completed its working.");
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("Inside the run method of MyThread class.");
        try {
            Thread.sleep(2000); //2000 millieseconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The run method of MyThread class has completed its working.");
    }
}

public class TestThreadCreation {

    public static void main(String[] args) {

        System.out.println("Inside the main thread");

        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        t1.start();

        Thread t2 = new MyThread();
        t2.start();

        System.out.println("Main program has ended");
    }
}
