package theme1algo.task1;

import java.util.Arrays;
import java.util.logging.Logger;

public class MyStack {
    private final Logger logger = Logger.getLogger(MyStack.class.getName());
    private final int[] stackArray;
    private int top = -1;
    private final int length;

    MyStack(int size) {
        stackArray = new int[size];
        length = size;
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        } else {
            logger.info("Inserting " + value);
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            logger.info("Removing " + peek());
            return stackArray[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return stackArray[top];
        }
    }

    public void print() {
        logger.info(Arrays.toString(stackArray));
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == length - 1;
    }
}
