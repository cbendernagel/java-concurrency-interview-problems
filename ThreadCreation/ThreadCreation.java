package ThreadCreation;

public class ThreadCreation {

    public static void main(String[] args) {
        System.out.println("hellow world!");
        ThreadCreationThread thread1 = new ThreadCreationThread();
        ThreadCreationThread thread2 = new ThreadCreationThread();
        ThreadCreationThread thread3 = new ThreadCreationThread();
        
        ThreadCreationRunnable runnable1 = new ThreadCreationRunnable();
        ThreadCreationRunnable runnable2 = new ThreadCreationRunnable();
        ThreadCreationRunnable runnable3 = new ThreadCreationRunnable();

        Thread thread4 = new Thread(runnable1);
        Thread thread5 = new Thread(runnable2);
        Thread thread6 = new Thread(runnable3);


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        
    }
}