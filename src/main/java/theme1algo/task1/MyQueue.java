package theme1algo.task1;

import java.util.Arrays;
import logger.AbstractLogger;

public class MyQueue extends AbstractLogger {
    private final int[] queueArray;
    private int front = 0;
    private int tail = -1;
    private int count = 0;
    private final int maxSize;

    MyQueue(int size) {
        queueArray = new int[size];
        maxSize = size;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        } else {
            LOGGER.info("Inserting " + value);
            tail = (tail + 1) % maxSize;
            queueArray[tail] = value;
            count++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else {
            int item = queueArray[front];
            LOGGER.info("Removing " + item);
            front = (front + 1) % maxSize;
            count--;
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else {
            return queueArray[front];
        }
    }

    public void print() {
        LOGGER.info(Arrays.toString(queueArray));
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == maxSize;
    }
}
