package algo.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyStackTest {

    @Test
    void stackTest() {
        MyStack stack = new MyStack(3);

        Assertions.assertThrows(IllegalStateException.class, stack::pop);
        stack.print();

        stack.push(1);
        stack.print();
        stack.push(2);
        stack.print();

        Assertions.assertEquals(2, stack.pop());
        stack.print();
        Assertions.assertEquals(1, stack.pop());
        stack.print();

        stack.push(3);
        stack.print();
        stack.push(4);
        stack.print();
        stack.push(5);
        stack.print();

        Assertions.assertThrows(IllegalStateException.class, () -> stack.push(6));

        Assertions.assertEquals(5, stack.peek());
        stack.print();
    }
}
