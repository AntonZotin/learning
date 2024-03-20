package theme6threads.task1;

public class Main {
    static int elements = 5;

    public static void main(String[] args) {
        MyThread[] myThreads = new MyThread[elements];
        Thread[] myRunnables = new Thread[elements];
        for (int i = 0; i < elements; i++) {
            MyThread thread = new MyThread(i + 1);
            myThreads[i] = thread;
            thread.start();
            Thread myRunnable = new Thread(new MyRunnable(i + 1));
            myRunnables[i] = myRunnable;
            myRunnable.start();
        }
    }
}
