package theme4concurrent.task2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);
        Runnable task = () -> {
            long result = 0;
            for (long i = 0; i < 1_000_000_000; i++) {
                result += i;
            }
            System.out.println("result = " + result);
            latch.countDown();
        };
        for (int i = 0; i < 3; i++) {
            service.submit(task);
        }
        latch.await();
        service.shutdown();
        System.out.println("All threads is finish");
    }
}
