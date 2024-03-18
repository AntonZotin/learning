package theme3core.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnimalTest {

    @Test
    void test() {
        Animal animal = new Dog("Archi", "Buldog");
        Assertions.assertEquals("Archi Buldog", animal.getName());
    }
}
