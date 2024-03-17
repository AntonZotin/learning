package theme4collecions.task2;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * HashMap: Время поиска элементов, мс: 75
 * TreeMap: Время поиска элементов, мс: 161
 */

public class Main {

    static int elements = 1_000_000;

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();

        for (int i = 0; i < elements; i++) {
            hashMap.put("ID" + i, "Vova" + i);
            treeMap.put("ID" + i, "Vova" + i);
        }

        System.out.println(hashMap);
        System.out.println(treeMap);

        for (int i = 0; i < elements; i++) {
            hashMap.put("ID" + i, "Vova" + i);
            treeMap.put("ID" + i, "Vova" + i);
        }

        System.out.println(hashMap);
        System.out.println(treeMap);

        Instant start = Instant.now();
        for (int i = 0; i < elements; i++) {
            hashMap.get("ID" + i);
        }
        long elapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("HashMap: Время поиска элементов, мс: " + elapsed);

        start = Instant.now();
        for (int i = 0; i < elements; i++) {
            treeMap.get("ID" + i);
        }
        elapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("TreeMap: Время поиска элементов, мс: " + elapsed);
    }
}
