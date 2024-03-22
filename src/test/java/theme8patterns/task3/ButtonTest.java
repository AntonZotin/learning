package theme8patterns.task3;

import org.junit.jupiter.api.Test;

class ButtonTest {

    @Test
    void test() {
        new WindowsDialog().createButton();
        new LinuxDialog().createButton();
    }
}
