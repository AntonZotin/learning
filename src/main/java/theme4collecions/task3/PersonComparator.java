package theme4collecions.task3;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        char[] name1 = o1.getName().toCharArray();
        char[] name2 = o2.getName().toCharArray();
        for (int i = 0; i < name1.length; i++) {
            int diff = name1[i] - name2[i];
            if (diff != 0)
                return diff;
        }
        return 0;
    }
}
