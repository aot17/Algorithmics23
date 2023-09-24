package students.fundamentals;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private T[] data;
    private int currentPosition;
    private static final int CAPACITY = 100;

    @SuppressWarnings("unchecked")
    public Stack() {
        data = (T[]) new Object[CAPACITY];
        currentPosition = -1;
    }

    public void push(T element){
        if (currentPosition == CAPACITY - 1){
            throw new IllegalStateException("Stack is FULL!");
        }
        data[++currentPosition] = element;
    }

    public T peek (){
        return data[currentPosition];
    }

    public T pop () {
        return data[currentPosition--];
    }
    public boolean isEmpty () {
        return currentPosition == - 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator <T>() {
            private int currentIndex = currentPosition;

            public boolean hasNext () {
                return currentIndex >=0;
            }
            public T next() {
                return data[currentIndex--];
            }
        };
    }

    public int size() {
        return currentPosition + 1;
    }
}