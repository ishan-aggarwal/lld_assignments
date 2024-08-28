package yash.fourth_threading;


class Resource {

    int count;

    public Resource(int count) {
        this.count = count;
    }

    public void increaseI() {
        for (int i = 1; i <= 10000; i++) {
            this.count++;
        }
    }

    public void decreaseI() {
        for (int i = 1; i <= 10000; i++) {
            this.count--;
        }
    }

    public int getCount() {
        return this.count;
    }
}

class MyRunnableAdder implements Runnable {

    private Resource r;

    public MyRunnableAdder(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        r.increaseI();
    }
}

class MyRunnableSubtractor implements Runnable {

    private Resource r;

    public MyRunnableSubtractor(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.decreaseI();
    }
}

public class TestCounterExample {

    public static void main(String[] args) throws InterruptedException {
        Resource r = new Resource(0);
//        r.increaseI();
//        r.decreaseI();
//        System.out.println(r.getCount());

        Thread t1 = new Thread(new MyRunnableAdder(r));
        Thread t2 = new Thread(new MyRunnableSubtractor(r));

        Thread t3 = new Thread(new MyRunnableAdder(r));
        Thread t4 = new Thread(new MyRunnableSubtractor(r));

        t1.start();
        t3.start();
        t2.start();
        t4.start();

        // call to join ensures that main method waits for the thread to complete on which join method is called.
        t1.join();
        t3.join();
        t2.join();
        t4.join();

        System.out.println(r.getCount());


    }


}
