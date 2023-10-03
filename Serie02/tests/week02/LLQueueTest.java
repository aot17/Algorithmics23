package week02;

import org.junit.Test;
import java.util.Iterator;
import java.util.Random;
import week02.LLQueue;

public class LLQueueTest {
    @Test
    public void test0()
    {
        LLQueue<Integer> integerQueue = new LLQueue<>();
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

    @Test
    public void test1()
    {
        LLQueue<Integer> integerQueue = new LLQueue<>();
        int count = 1000;

        Random rand = new Random();

        int lastIn = 0;
        int lastOut = 0;

        for (int i = 0; i < count; ) {
            if (integerQueue.isEmpty() || rand.nextDouble() < .7) {
                i++;
                integerQueue.enqueue(++lastIn);
            } else {
                int out = integerQueue.dequeue();
                assert out == lastOut + 1;
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

    @Test
    public void test2(){
        LLQueue<Integer> integerQueue = new LLQueue<>();

        integerQueue.enqueue(100);
        integerQueue.enqueue(101);
        integerQueue.enqueue(102);
        assert integerQueue.size() == 3;

        assert integerQueue.peek() == 100;
        integerQueue.dequeue();
        assert integerQueue.peek() == 101;
        integerQueue.dequeue();
        assert integerQueue.peek() == 102;
        integerQueue.dequeue();
        assert integerQueue.isEmpty();
    }

    @Test
    public void test3(){
        LLQueue<String> stringQueue = new LLQueue<>();
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