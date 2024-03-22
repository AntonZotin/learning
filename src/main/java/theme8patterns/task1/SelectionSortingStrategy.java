package theme8patterns.task1;

import java.util.List;

public class SelectionSortingStrategy implements SortingStrategy {
    @Override
    public void sort(List<Integer> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int minIdx = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < list.get(minIdx)) {
                    minIdx = j;
                }
            }
            int tmp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, tmp);
            count += 2;
        }
        System.out.println("SelectionSort: Всего сделано " + count + " перемещений элементов.");
    }
}
