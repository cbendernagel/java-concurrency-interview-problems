package ThreadCreation;

public class ThreadCreation {

    public static void main(String[] args) {
        System.out.println("hellow world!");
        ThreadCreationThread thread1 = new ThreadCreationThread();
        ThreadCreationThread thread2 = new ThreadCreationThread();
        ThreadCreationThread thread3 = new ThreadCreationThread();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}