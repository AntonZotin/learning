package theme8patterns.task1;

import java.util.List;

public class BubbleSortingStrategy implements SortingStrategy {
    @Override
    public void sort(List<Integer> list) {
        int count = 0;
        for (int i = list.size() - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                if(list.get(j) > list.get(j + 1)) {
                    Integer temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    count += 2;
                }
            }
        }
        System.out.println("BubbleSort: Всего сделано " + count + " перемещений элементов.");
    }
}
