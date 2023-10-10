package week01;

import java.util.Iterator;
public class Queue<T> implements Iterable<T> {
    private T[] queue;
    private final int CAPACITY;
    private int front, rear, size;

    @SuppressWarnings("unchecked")
    public Queue(int n) {
        queue = (T[]) new Object[n];
        CAPACITY = n;
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T e) {
        if (CAPACITY > rear) {
            queue[++rear] = e;
            size++;
        } else {
            throw new RuntimeException("enqueue(): Queue full");
        }
    }

    public T dequeue() {
        if (!isEmpty()) {
            size--;
            return queue[front++];
        } else {
            throw new RuntimeException("dequeue(): Queue empty");
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return queue[front];
        } else {
            throw new RuntimeException("Queue empty!");
        }
    }

    public boolean isEmpty() {
        return rear < front;
    }

    public int size() {
        return size;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = Queue.this.front;
            @Override
            public boolean hasNext() {
                return index <= Queue.this.rear;
            }

            @Override
            public T next() {
                return queue[index++];
            }
        };
    }

}
