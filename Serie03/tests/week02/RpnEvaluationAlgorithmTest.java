package week02;

import week02.RpnEvaluationAlgorithm;
import week02.Token;
import week01.Queue;
import org.junit.Test;

public class RpnEvaluationAlgorithmTest {

    @Test
    public void evaluateExpression()
    {
        Queue<Token> tokenQueue = new Queue<>(99);

        tokenQueue.enqueue(new Token(5));
        tokenQueue.enqueue(new Token(4));
        tokenQueue.enqueue(new Token(Token.OperatorType.Plus));

        assert new RpnEvaluationAlgorithm().evaluateExpression(tokenQueue) == 9;
    }
}