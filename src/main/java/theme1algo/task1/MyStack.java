package theme1algo.task1;

import java.util.Arrays;

public class MyStack {
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
            System.out.println("Inserting " + value);
            stackArray[++top] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            System.out.println("Removing " + peek());
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
        System.out.println(Arrays.toString(stackArray));
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == length - 1;
    }
}
