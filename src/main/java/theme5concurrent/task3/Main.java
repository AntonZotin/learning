package theme5concurrent.task3;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * ConcurrentHashMap: Время чтения элементов, мс: 302
 * HashMap: Время чтения элементов, мс: 1
 */
public class Main {
    static final int THREADS = 5;
    static final int ELEMENTS = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        ExecutorService service = Executors.newFixedThreadPool(THREADS);
        CountDownLatch writeLatch = new CountDownLatch(THREADS);
        for (int i = 0; i < THREADS; i++) {
            service.execute(() -> {
                for (int i1 = 0; i1 < ELEMENTS; i1++) {
                    hashMap.put("ID" + i1, "Name" + i1);
                }
                writeLatch.countDown();
            });
        }
        writeLatch.await();

        CountDownLatch readLatch = new CountDownLatch(THREADS);
        Instant start = Instant.now();
        for (int i = 0; i < THREADS; i++) {
            service.execute(() -> {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    String result = entry.getKey() + " : " + entry.getValue();
                }
                readLatch.countDown();
            });
        }
        readLatch.await();
        long elapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("ConcurrentHashMap: Время чтения элементов, мс: " + elapsed);

        CountDownLatch simpleReadLatch = new CountDownLatch(THREADS);
        HashMap<String, String> hashMap2 = new HashMap<>();
        for (int i = 0; i < ELEMENTS; i++) {
            hashMap2.put("ID" + i, "Name" + i);
        }
        start = Instant.now();
        for (int i = 0; i < THREADS; i++) {
            service.execute(() -> {
                for (Map.Entry<String, String> entry : hashMap2.entrySet()) {
                    String result = entry.getKey() + " : " + entry.getValue();
                }
                simpleReadLatch.countDown();
            });
        }
        readLatch.await();
        elapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("HashMap: Время чтения элементов, мс: " + elapsed);

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);

    }
}
