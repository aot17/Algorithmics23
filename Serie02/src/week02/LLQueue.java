package week02;

import java.util.Iterator;

public class LLQueue<T> implements Iterable<T> {
    private Node head;
    private int nbOfItems;

    public LLQueue() {
        head = null;
        nbOfItems = 0;
    }

    private class Node {
        T item;
        Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public void enqueue(T item) {
        Node newNode = new Node(item, null);
        if (head != null) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        } else {
            head = newNode;
        }
        nbOfItems++;
    }

    public T dequeue() {
        if (head == null) {
            return null;
        }
        T item = head.item;
        head = head.next;
        nbOfItems--;
        return item;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.item;
    }

    public int size() {
        return nbOfItems;
    }

    public boolean isEmpty() {
        return nbOfItems == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node currentNode = LLQueue.this.head;
            @Override
            public boolean hasNext() {
                return  currentNode != null;
            }

            @Override
            public T next() {
                T item = currentNode.item;
                currentNode = currentNode.next;
                return item;
            }
        };
    }
}
