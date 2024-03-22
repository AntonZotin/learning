package theme8patterns.task1;

import java.util.List;

public class InsertionSortingStrategy implements SortingStrategy {
    @Override
    public void sort(List<Integer> list) {
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
                count++;
            }
            list.set(j + 1, key);
            count++;
        }
        System.out.println("InsertionSort: Всего сделано " + count + " перемещений элементов.");
    }
}
