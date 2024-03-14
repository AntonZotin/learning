package theme2jvm.task1;

import java.util.Arrays;
import logger.AbstractLogger;

public class Main extends AbstractLogger {
    static Runtime runtime = Runtime.getRuntime();

    public static void main(String[] args) throws InterruptedException {
        print();
        int[][] bigArray = new int[2000][];
        print();
        while (true) {
            if (bigArray[0] == null) {
                for (int i = 0; i < bigArray.length; i++) {
                    int[] arr = new int[10000];
                    Arrays.fill(arr, 120);
                    bigArray[i] = arr;
                }
                LOGGER.info("Filled");
                print();
            } else {
                for (int i = 0; i < bigArray.length; i++) {
                    bigArray[i] = null;
                }
                LOGGER.info("Unfilled");
                print();
            }
            Thread.sleep(5000);
        }
    }

    static void print() {
        LOGGER.info("Total " + runtime.totalMemory());
        LOGGER.info("Max " + runtime.maxMemory());
        LOGGER.info("Free " + runtime.freeMemory());
    }
}
