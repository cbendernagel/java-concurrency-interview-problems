package Synchronization;

import java.util.concurrent.TimeUnit;

public class LongRunningThread extends Thread {
    private String threadId = "LongRunningThread";
    private volatile boolean isInterupted = false;

    @Override
    public void run() {
            int count = 1;
            while(true) {
                try {
                    System.out.println("[" + threadId + "] COUNT: " + count++);
                    TimeUnit.MILLISECONDS.sleep(3000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                synchronized(this) {
                    if(isInterupted) {
                        System.out.println("[" + threadId + "] INTERRUPT CAUGHT");
                        break;
                    }
                }
            }

        System.out.println("[" + threadId + "] COMPLETE");
    }

    public void cancel() {
        System.out.println("[" + Thread.currentThread().getName() + "]- HAS BEEN INTERRUPTED!");
        synchronized(this) {
            isInterupted = true;
        }
    }
}
