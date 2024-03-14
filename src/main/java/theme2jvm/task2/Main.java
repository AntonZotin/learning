package theme2jvm.task2;

import java.util.Arrays;

/**
 * Before execute program edit Intellij run configuration:
 * Modify options -> Add VM options
 * Add option -XX:+PrintGCDetails
 */
public class Main {
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
                System.gc();
                System.out.println("Filled");
                print();
            } else {
                for (int i = 0; i < bigArray.length; i++) {
                    bigArray[i] = null;
                }
                System.gc();
                System.out.println("Unfilled");
                print();
            }
            Thread.sleep(5000);
        }
    }

    static void print() {
        System.out.println("Total " + runtime.totalMemory());
        System.out.println("Max " + runtime.maxMemory());
        System.out.println("Free " + runtime.freeMemory());
    }
}
