package theme7threads.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private final AtomicInteger cash = new AtomicInteger(0);

    public int addCash(int cash) {
        return this.cash.addAndGet(cash);
    }

    public int removeCash(int cash) {
        return this.cash.addAndGet(-cash);
    }
}
