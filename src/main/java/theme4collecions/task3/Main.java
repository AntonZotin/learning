package theme4collecions.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Андрей", 10));
        list.add(new Person("Иван", 90));
        list.add(new Person("Ургант", 15));
        list.add(new Person("Виктор", 21));
        list.add(new Person("Макар", 44));
        list.add(new Person("Семён", 25));
        list.add(new Person("Воланд", 18));
        list.add(new Person("Прасковья", 78));
        list.add(new Person("Лумумба", 66));

        for (Person p: list) {
            System.out.println(p);
        }
        System.out.println();

        Collections.sort(list);

        for (Person p: list) {
            System.out.println(p);
        }
        System.out.println();

        Collections.sort(list, new PersonComparator());

        for (Person p: list) {
            System.out.println(p);
        }
        System.out.println();
    }
}
