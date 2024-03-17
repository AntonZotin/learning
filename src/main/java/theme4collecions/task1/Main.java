package theme4collecions.task1;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ArrayList: Время добавления элементов в начале, мс: 95897
 * ArrayList: Время удаления элементов в начале, мс: 86359
 * LinkedList: Время добавления элементов в начале, мс: 118
 * LinkedList: Время удаления элементов в начале, мс: 14
 * ArrayList: Время добавления элементов в середине, мс: 45471
 * ArrayList: Время удаления элементов в середине, мс: 43485
 * LinkedList: Время добавления элементов в середине, мс: 1097366 ~ 18 минут
 * LinkedList: Время удаления элементов в середине, мс: 757166 ~ 12 минут
 * ArrayList: Время добавления элементов в конце, мс: 26
 * ArrayList: Время удаления элементов в конце, мс: 23
 * LinkedList: Время добавления элементов в конце, мс: 77
 * LinkedList: Время удаления элементов в конце, мс: 36
 */

public class Main {

    static int elements = 1_000_000;

    public static void main(String[] args) {
        processArrayList("начале", 0);
        processLinkedList("начале", 0);
        processArrayList("середине", 1);
        processLinkedList("середине", 1);
        processArrayList("конце", 2);
        processLinkedList("конце", 2);
    }

    static void processArrayList(String field, int place) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Instant start = Instant.now();
        for (int i = 0; i < elements; i++) {
            if (place == 0)
                arrayList.add(0, i);
            else if (place == 1)
                arrayList.add(arrayList.size() / 2, i);
            else
                arrayList.add(i);
            if (i % (elements / 10) == 0)
                System.out.println("ArrayList: " + i);
        }
        long elapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("ArrayList: Время добавления элементов в " + field + ", мс: " + elapsed);

        start = Instant.now();
        for (int i = 0; i < elements; i++) {
            if (place == 0)
                arrayList.remove(0);
            else if (place == 1)
                arrayList.remove(arrayList.size() / 2);
            else
                arrayList.remove(arrayList.size() - 1);
            if (i % (elements / 10) == 0)
                System.out.println("ArrayList: " + i);
        }
        elapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("ArrayList: Время удаления элементов в " + field + ", мс: " + elapsed);
    }

    static void processLinkedList(String field, int place) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Instant start = Instant.now();
        for (int i = 0; i < elements; i++) {
            if (place == 0)
                linkedList.add(0, i);
            else if (place == 1)
                linkedList.add(linkedList.size() / 2, i);
            else
                linkedList.add(i);
            if (i % (elements / 10) == 0)
                System.out.println("LinkedList: " + i);
        }
        long elapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("LinkedList: Время добавления элементов в " + field + ", мс: " + elapsed);

        start = Instant.now();
        for (int i = 0; i < elements; i++) {
            if (place == 0)
                linkedList.remove(0);
            else if (place == 1)
                linkedList.remove(linkedList.size() / 2);
            else
                linkedList.remove(linkedList.size() - 1);
            if (i % (elements / 10) == 0)
                System.out.println("LinkedList: " + i);
        }
        elapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("LinkedList: Время удаления элементов в " + field + ", мс: " + elapsed);
    }
}
