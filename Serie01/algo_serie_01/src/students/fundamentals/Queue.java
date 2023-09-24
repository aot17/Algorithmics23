package students.fundamentals;

import java.util.Iterator;

public class Queue<T> implements Iterable {
    private T[] data;
    private int front, rear, size;
    private static final int CAPACITY = 1000;

    @SuppressWarnings("unchecked")
    public Queue() {
        data = (T[]) new Object[CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T element) {
        if (size == CAPACITY) {
            throw new IllegalStateException("Queue is full!");
        }
        rear = (rear + 1) % CAPACITY; // Circular queue
        data[rear] = element;
        size++;
    }

    public T dequeue() {
        T item = data[front];
        front = (front + 1) % CAPACITY;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                T item = data[(front + currentIndex) % CAPACITY];
                currentIndex++;
                return item;
            }
        };
    }
}