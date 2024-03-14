package theme1algo.task2;

import java.util.Random;
import org.junit.jupiter.api.Test;

class MegaArrayTest {
    final int LENGTH = 50;

    @Test
    void test() {
        Random random = new Random();
        int[] values = new int[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            values[i] = random.nextInt(LENGTH * 2);
        }
        MegaArray array = new MegaArray(values);
        array.print();
        array.mergeSort();
        array.print();
        for (int i = 1; i < 30; i++) {
            System.out.println(i + " has index " + array.binarySearch(i));
        }
    }
}
