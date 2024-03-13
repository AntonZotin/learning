package algo.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyQueueTest {

    @Test
    void test() {
        MyQueue queue = new MyQueue(3);

        Assertions.assertThrows(IllegalStateException.class, queue::dequeue);
        queue.print();

        queue.enqueue(1);
        queue.print();
        queue.enqueue(2);
        queue.print();

        Assertions.assertEquals(1, queue.dequeue());
        queue.print();
        Assertions.assertEquals(2, queue.dequeue());
        queue.print();

        queue.enqueue(3);
        queue.print();
        queue.enqueue(4);
        queue.print();
        queue.enqueue(5);
        queue.print();

        Assertions.assertThrows(IllegalStateException.class, () -> queue.enqueue(6));

        Assertions.assertEquals(3, queue.peek());
        queue.print();
    }

}
