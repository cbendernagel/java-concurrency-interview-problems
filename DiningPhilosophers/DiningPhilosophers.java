

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    public static void main(String[] args) throws InterruptedException {
        String threadId = Thread.currentThread().getName();
        System.out.println(threadId + "- START");
        
        int numPhilosophers = 5;
        Semaphore[] chopsticks = new Semaphore[numPhilosophers];
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        for(int i = 0; i < numPhilosophers; i++) {
            chopsticks[i] = new Semaphore(1);
        }
        
        for(int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % numPhilosophers]);
            philosophers[i].start();
        }

        Thread.sleep(15000);
        for(int i = 0; i < numPhilosophers; i++) {
            philosophers[i].interrupt();
        }

        System.out.println(threadId + "- COMPLETE");
    }
}
