package theme7threads.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static int threads = 1000;

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        ExecutorService service = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            String name = "Thread " + i;
            service.submit(() -> {
                while (true) {
                    int sum = account.addCash(100);
                    if (sum > 100*threads) {
                        System.out.println("ERROR: " + sum);
                        System.exit(0);
                    }
                    System.out.println(name + " внёс 100, осталось " + sum);
                    Thread.sleep(1000);
                    sum = account.removeCash(100);
                    if (sum < 0) {
                        System.out.println("ERROR: " + sum);
                        System.exit(0);
                    }
                    System.out.println(name + " вынес 100, осталось " + sum);
                    Thread.sleep(1000);
                }
            });
        }
    }
}
