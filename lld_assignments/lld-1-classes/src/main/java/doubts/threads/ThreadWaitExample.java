package doubts.threads;

import javax.xml.crypto.Data;
import java.util.Date;

class MyRunnable1 implements Runnable {

    private Object obj;

    public MyRunnable1(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {

            System.out.println("Inside the synchronized run method for consumer. Waiting for shopkeeper to bring item: " + new Date());
            try {
                obj.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("End the synchronized run method for consumer. Got the item: " + new Date());
        }
    }
}


class MyRunnable2 implements Runnable {

    private Object obj;

    public MyRunnable2(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {

            System.out.println("Inside the synchronized run method for producer. Going to call notify: " + new Date());
            obj.notify();
            System.out.println("End the synchronized run method for producer. Called notify: " + new Date());
        }
    }
}

public class ThreadWaitExample {

    public static void main(String[] args) throws InterruptedException {

        final Object obj = new Object();

        Runnable r1 = new MyRunnable1(obj);
        Thread t1 = new Thread(r1);
        t1.start();

        Thread.sleep(10 * 1000);

        Runnable r2 = new MyRunnable2(obj);
        Thread t2 = new Thread(r2);
        t2.start();
    }
}
