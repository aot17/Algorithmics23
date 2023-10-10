package week01;

import week01.Queue;
import org.junit.Test;
import java.util.Iterator;
import java.util.Random;

public class QueueTest
{
    // Simple test, basic functionality
    @Test
    public void test0()
    {
        Queue<Integer> integerQueue = new Queue(99);
        integerQueue.enqueue(1);

        assert !integerQueue.isEmpty();

        integerQueue.enqueue(2);
        integerQueue.enqueue(3);

        assert integerQueue.dequeue() == 1;
        assert integerQueue.dequeue() == 2;
        assert integerQueue.dequeue() == 3;
        assert integerQueue.isEmpty();

        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        integerQueue.enqueue(3);
        integerQueue.enqueue(4);

        assert integerQueue.dequeue() == 1;
        assert integerQueue.dequeue() == 2;
        assert integerQueue.dequeue() == 3;
        assert integerQueue.dequeue() == 4;
        assert integerQueue.isEmpty();
    }

    // A bit more complex
    @Test
    public void test1()
    {
        Queue<Integer> integerQueue = new Queue(1000);
        int count = 1000;

        Random rand = new Random();

        int lastIn = 0;
        int lastOut = 0;

        for (int i = 0; i < count; ) {
            if (integerQueue.isEmpty() || rand.nextDouble() < .7) {
                i++;
                //System.out.println("adding " + (lastIn + 1));
                integerQueue.enqueue(++lastIn);
            } else {
                int out = integerQueue.dequeue();
                assert out == lastOut + 1;
                //System.out.println("removing " + out);
                lastOut = out;
            }
        }

        assert lastIn == count;

        while (!integerQueue.isEmpty()) {
            int out = integerQueue.dequeue();
            assert out == lastOut + 1;
            //System.out.println("removing " + out);
            lastOut = out;
        }

        assert  lastOut == count;
    }

    // Test the peek() method
    @Test
    public void test2(){
        Queue<Integer> integerQueue = new Queue(99);

        integerQueue.enqueue(100);
        integerQueue.enqueue(101);
        integerQueue.enqueue(102);

        assert integerQueue.peek() == 100;
        integerQueue.dequeue();
        assert integerQueue.peek() == 101;
        integerQueue.dequeue();
        assert integerQueue.peek() == 102;
        integerQueue.dequeue();
        // We do not let peek() return a null value.
        // assert integerQueue.peek() == null;
        assert integerQueue.isEmpty();
    }

    // Test the iter method
    @Test
    public void test3(){
        Queue<String> stringQueue = new Queue(99);
        stringQueue.enqueue("Sun");
        stringQueue.enqueue("Star");
        stringQueue.enqueue("Cloud");
        stringQueue.enqueue("Lightning");

        Iterator iterator = stringQueue.iterator();

        String[] verify = {"Sun", "Star", "Cloud", "Lightning"}; // exactly in this order
        int i = 0;

        while(iterator.hasNext()) {
            assert iterator.next() == verify[i];
            i++;
        }

    }
}