package ThreadCreation;

import java.util.concurrent.TimeUnit;

public class ThreadCreationRunnable implements Runnable {
    public static int count;
    private final String idPrefix = "Runnable-";
    private String threadId;

    public ThreadCreationRunnable() {
        this.threadId = idPrefix + ++count;
    }
    
    public void run() {
        System.out.println("[" + threadId + "] STARTED");
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println("[" + threadId + "] counter=" + i);
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("[" + threadId + "] COMPLETED");
    }
}
