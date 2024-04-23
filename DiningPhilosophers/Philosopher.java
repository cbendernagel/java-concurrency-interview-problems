

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    public static int count;
    private final String prefix = "Philosopher-";
    private String id;
    private Semaphore leftChopstick;
    private Semaphore rightChopstick;

    public Philosopher(Semaphore leftChopstick, Semaphore rightChopstick) {
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.id = prefix + ++count;
    }

    private void think() throws InterruptedException {
        System.out.println(id + " is thinking");
        Thread.sleep(2000);
    }

    private void eat() throws InterruptedException {
        leftChopstick.acquire();
        rightChopstick.acquire();

        System.out.println(id + " is eating");
        Thread.sleep(2000);

        leftChopstick.release();
        rightChopstick.release();
    }

    @Override
    public void run() {
        try {
            while(true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
