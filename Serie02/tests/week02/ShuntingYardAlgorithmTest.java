package week02;

import week02.ShuntingYardAlgorithm;
import week02.Token;
import week01.Queue;
import org.junit.Test;

public class ShuntingYardAlgorithmTest {

    @Test
    public void convertToRPN() {
        Queue<Token> inQ = new Queue<>(999);
        Token three = new Token(3), plus = new Token(Token.OperatorType.Plus), four = new Token(4);

        inQ.enqueue(three);
        inQ.enqueue(plus);
        inQ.enqueue(four);

        Queue<Token> outQ = new ShuntingYardAlgorithm().convertToRPN(inQ);

        assert outQ.dequeue() == three;
        assert outQ.dequeue() == four;
        assert outQ.dequeue() == plus;
    }
}