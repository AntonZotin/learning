package theme8patterns.task1;

import java.util.List;

public class SortingService {
    SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(List<Integer> list) {
        if (sortingStrategy == null)
            throw new NullPointerException("Strategy is null");
        sortingStrategy.sort(list);
    }
}
