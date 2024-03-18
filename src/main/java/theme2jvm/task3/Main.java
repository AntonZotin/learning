package theme2jvm.task3;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("CustomEnum must have 4 fields: EPIC, HARD, EASY and MIDDLE");
        CustomClassLoader loader = new CustomClassLoader();
        Class customEnum = loader.findClass("theme2jvm.task3.CustomEnum");
        Arrays.stream(customEnum.getFields()).map(Field::getName).forEach(System.out::println);
    }
}
