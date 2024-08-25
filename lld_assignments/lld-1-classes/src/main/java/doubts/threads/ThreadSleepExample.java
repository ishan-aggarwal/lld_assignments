package doubts.threads;

import java.util.Date;
import java.lang.Object;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Inside run");

        // static method and not non-static method
        // kynk hum yeh hamesha jo bhi current executing thread usko pause karne ke lie call karte hai...
        // hum isko apni marzi se kisi bhi aur thread ko pause karne ke lie call nahi kar sakte...
        // t1.sleep() (yeh allowed nahi hai)
        // kynk mujhe nahi pata ki CPU is time kis current thread kaunsa exeucte ho raha hoga
        // t1.sleep() (hume nahi pata ki current kaunsa hai islie mein ise non-static nahi bana sakta)
        // Thread.sleep() (this is correct)
        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ThreadSleepExample {

    public static void main(String[] args) throws InterruptedException { // main thread

        System.out.println(Thread.currentThread().getName());

        System.out.println("First line : " + new Date());
        System.out.println("Second line : " + new Date());
        System.out.println("Third line : " + new Date());

        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();

        Thread t1 = new Thread(r);
        t1.start();

        // sleep means the current thread will pause for specified time in milliseconds
        try {
            // static method
            // class name.method name
            Thread.sleep(60 * 1000); // 60000 milliseconds and 60 seconds = 1 minute
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception was raised : " + e.getMessage());
        }
        System.out.println("Last line : " + new Date());

    }
}
