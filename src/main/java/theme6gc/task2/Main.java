package theme6gc.task2;

import java.util.LinkedList;

public class Main {
    static int elements = 1_000_000;
    static long[] array;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            LinkedList<Integer> linkedList = new LinkedList<>();
            fillLinkedList(linkedList);
            System.out.println("Массив заполнен");
            Thread.sleep(15000L);
            linkedList = null;
            System.out.println("массив удалён");
            Thread.sleep(15000L);
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
