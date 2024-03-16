package theme2jvm.task3;

import java.lang.reflect.Field;
import java.util.Arrays;
import logger.AbstractLogger;

public class Main extends AbstractLogger {

    public static void main(String[] args) {
        LOGGER.info("CustomEnum must have 4 fields: EPIC, HARD, EASY and MIDDLE");
        CustomClassLoader loader = new CustomClassLoader();
        Class customEnum = loader.findClass("theme2jvm.task3.CustomEnum");
        Arrays.stream(customEnum.getFields()).map(Field::getName).forEach(LOGGER::info);
    }
}
