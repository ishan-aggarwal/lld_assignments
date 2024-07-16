package doubt_semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {

    private static final Semaphore semaphore = new Semaphore(1);

    public SharedResource() {
    }

    public void producer() {
        try {
            System.out.println("Going to acquire Semaphore by: " + Thread.currentThread().getName());
            semaphore.acquire();
            synchronized (System.out) {
                System.out.println("Semaphore acquired by: " + Thread.currentThread().getName());
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally {
            semaphore.release();
            synchronized (System.out) {
                System.out.println("Semaphore released by: " + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // Example threads using the shared resource
        Thread producerThread1 = new Thread(sharedResource::producer);
        Thread producerThread2 = new Thread(sharedResource::producer);

        producerThread1.start();
        producerThread2.start();
    }
}
