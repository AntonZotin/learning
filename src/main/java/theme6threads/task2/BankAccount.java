package theme6threads.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private AtomicInteger cash = new AtomicInteger(0);

    public AtomicInteger getCash() {
        return cash;
    }

    public void setCash(AtomicInteger cash) {
        this.cash = cash;
    }

    public int addCash(int cash) {
        return this.cash.addAndGet(cash);
    }

    public int removeCash(int cash) {
        return this.cash.addAndGet(-cash);
    }
}
