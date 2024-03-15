package theme3core.task1;

import logger.AbstractLogger;

public class Main extends AbstractLogger {
    public static void main(String[] args) {
        Animal animal = new Dog("Archi", "Buldog");
        LOGGER.info(animal.getName());
    }
}
