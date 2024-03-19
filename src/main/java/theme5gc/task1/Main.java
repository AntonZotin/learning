package theme5gc.task1;

import java.util.LinkedList;

/**
 * Before execute program edit Intellij run configuration:
 * Modify options -> Add VM options
 * Add option -XX:+UseSerialGC || -XX:+UseParallelGC || -XX:+UseG1GC
 * Add option -Xms50m
 * Add option -Xmx100m
 */
public class Main {

    static int elements = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        while(true) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            fillLinkedList(linkedList);
            System.out.println("Массив заполнен");
            Thread.sleep(5000L);
            linkedList.clear();
            System.out.println("Массив очищен");
            Thread.sleep(5000L);
        }
    }

    static void fillLinkedList(LinkedList<Integer> linkedList) {
        for (int i = 0; i < elements; i++) {
            linkedList.add(i);
            if (i % (elements / 10) == 0)
                System.out.println("LinkedList: " + i);
        }
    }
}
