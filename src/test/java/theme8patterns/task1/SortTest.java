package theme8patterns.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortTest {
    static final int ELEMENTS = 100;
    Random random = new Random();
    SortingService service = new SortingService();

    @Test
    void test() {
        Integer[] originalArray = new Integer[ELEMENTS];
        for (int i = 0; i < ELEMENTS; i++) {
            originalArray[i] = random.nextInt(ELEMENTS);
        }
        Assertions.assertThrows(NullPointerException.class,
                () -> service.sort(new ArrayList<>(Arrays.asList(originalArray)))
        );
        makeSort(new ArrayList<>(Arrays.asList(originalArray)), new BubbleSortingStrategy());
        makeSort(new ArrayList<>(Arrays.asList(originalArray)), new InsertionSortingStrategy());
        makeSort(new ArrayList<>(Arrays.asList(originalArray)), new SelectionSortingStrategy());
    }

    private void makeSort(List<Integer> list, SortingStrategy strategy) {
        System.out.println(list);
        service.setSortingStrategy(strategy);
        service.sort(list);
        System.out.println(list);
        System.out.println();
    }
}
