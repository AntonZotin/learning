package theme4collecions.task3;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        char[] name1 = o1.getName().toCharArray();
        char[] name2 = o2.getName().toCharArray();
        for (int i = 0; i < name1.length - 1; i++) {
            if (i > name2.length - 1)
                return 1;
            int diff = name1[i] - name2[i];
            if (diff != 0)
                return diff;
        }
        if (name1.length < name2.length)
            return -1;
        return 0;
    }
}
