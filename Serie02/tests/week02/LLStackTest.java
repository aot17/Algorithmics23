package week02;

import org.junit.Test;
import week02.LLStack;
import java.util.Iterator;
import java.util.Random;

public class LLStackTest {
    @Test
    public void test0() {
        LLStack<Integer> integerStack = new LLStack<>();
        integerStack.push(1);

        assert !integerStack.isEmpty();

        integerStack.push(2);
        integerStack.push(3);

        assert integerStack.pop() == 3;
        assert integerStack.pop() == 2;
        assert integerStack.pop() == 1;

        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);

        assert integerStack.pop() == 4;
        assert integerStack.pop() == 3;
        assert integerStack.pop() == 2;
        assert integerStack.pop() == 1;
        assert integerStack.isEmpty();
    }

    @Test
    public void test1() {
        LLStack<Integer> integerStack = new LLStack<>();
        int count = 1000;

        Random rand = new Random();

        int top = 0;

        for (int i = 0; i < count; ) {
            if (integerStack.isEmpty() || rand.nextDouble() < .7) {
                i++;
                integerStack.push(++top);
            } else {
                int out = integerStack.pop();
                assert out == top;
                top--;
            }
        }

        while (!integerStack.isEmpty()) {
            int out = integerStack.pop();
            assert out == top;
            top--;
        }
    }

    // Test the peek() method
    @Test
    public void test2() {
        LLStack<Integer> integerStack = new LLStack<>();

        integerStack.push(100);
        integerStack.push(101);
        integerStack.push(102);
        assert integerStack.size() == 3;

        assert integerStack.peek() == 102;
        integerStack.pop();
        assert integerStack.peek() == 101;
        integerStack.pop();
        assert integerStack.peek() == 100;
        integerStack.pop();
        assert integerStack.isEmpty();
    }

    @Test
    public void test3() {
        LLStack<String> stringStack = new LLStack<>();

        stringStack.push("Lightning");
        stringStack.push("Cloud");
        stringStack.push("Star");
        stringStack.push("Sun");

        Iterator iterator = stringStack.iterator();

        String[] verify = {"Sun", "Star", "Cloud", "Lightning"};
        int i = 0;

        while (iterator.hasNext()) {
            assert iterator.next() == verify[i];
            i++;
        }

    }
}

