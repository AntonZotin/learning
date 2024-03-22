package theme7threads.task1;

public class MyThread extends Thread{

    private int identifier;

    public MyThread(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("MyThread " + this.identifier);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
