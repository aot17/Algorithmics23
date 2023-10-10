package week01;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private final T[] stack;
    private final int CAPACITY;
    private int index = -1;

    @SuppressWarnings("unchecked")
    public Stack(int n) {
        CAPACITY = n;
        stack = (T[]) new Object[n];
    }
    public void push(T e) {
        if(CAPACITY > index) {
            stack[++index] = e;
        } else {
            throw new RuntimeException("push(): Stack capacity reached.");
        }

    }

    public T pop() {
        if (!isEmpty()) {
            return stack[index--];
        } else {
            throw new RuntimeException("pop(): Stack is empty");
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return stack[index];
        } else {
            throw new RuntimeException("peek(): Stack is empty");
        }
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i <= index; i++) {
            size++;
        }
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = Stack.this.index;
            @Override
            public boolean hasNext() {
                return index > -1;
            }

            @Override
            public T next() {
                return stack[index--];
            }
        };
    }
}
