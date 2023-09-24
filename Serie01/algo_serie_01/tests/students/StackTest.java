package students;

import org.junit.Assert;
import org.junit.Test;
import students.fundamentals.Stack;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
    }

    @Test
    public void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(Integer.valueOf(2), stack.peek());
        stack.push(3);
        Assert.assertEquals(Integer.valueOf(3), stack.peek());
    }

    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<>();
        Assert.assertTrue(stack.isEmpty());
        stack.push(1);
        Assert.assertFalse(stack.isEmpty());
        stack.pop();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        Stack<Integer> stack = new Stack<>();
        Assert.assertEquals(0, stack.size());
        stack.push(1);
        Assert.assertEquals(1, stack.size());
        stack.push(2);
        Assert.assertEquals(2, stack.size());
        stack.pop();
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void testIterator() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int expectedValue = 3;
        for (Integer value : stack) {
            Assert.assertEquals(Integer.valueOf(expectedValue--), value);
        }
    }
}
