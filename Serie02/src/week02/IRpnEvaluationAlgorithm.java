package week02;

import week01.Queue;

public interface IRpnEvaluationAlgorithm {
    double evaluateExpression(Queue<Token> inputQueue);
}
