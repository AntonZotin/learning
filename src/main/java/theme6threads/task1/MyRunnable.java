package theme6threads.task1;

public class MyRunnable implements Runnable{

    private int identifier;

    public MyRunnable(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("MyRunnable " + this.identifier);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
