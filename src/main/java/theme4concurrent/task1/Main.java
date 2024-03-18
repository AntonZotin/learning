package theme4concurrent.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Runnable task = () -> {
            int result = 100 / 10 * 500_000 - 200 + 5;
            System.out.println("result = " + result);
        };
        for (int i = 0; i < 10; i++) {
            service.execute(task);
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
    }
}
