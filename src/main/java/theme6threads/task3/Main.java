package theme6threads.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static int threads = 3;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < threads; i++) {
            String name = "Thread " + i;
            service.submit(() -> {
                while (true) {
                    System.out.println(name);
                    Thread.sleep(1000);
                }
            });
        }
        Thread.sleep(3000);
        System.out.println("Try to shutdown");
        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        System.out.println("Try to shutdown Now");
        service.shutdownNow();
        System.out.println("Service shutdown");
    }
}
