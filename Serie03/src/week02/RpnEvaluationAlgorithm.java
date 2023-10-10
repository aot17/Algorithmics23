package week02;

import week01.Queue;
import week01.Stack;

public class RpnEvaluationAlgorithm implements IRpnEvaluationAlgorithm {
    @Override
    public double evaluateExpression(Queue<Token> inputQueue) {
        Stack<Double> stack = new Stack<>(99);

        for (Token token : inputQueue) {
            switch (token.type) {
                case Numeric:
                    stack.push(token.asNumber);
                    break;
                case Operator:
                    Double operand2 = stack.pop();
                    Double operand1 = stack.pop();
                    switch (token.asOperator) {
                        case Plus -> stack.push(operand1 + operand2);
                        case Minus -> stack.push(operand1 - operand2);
                        case Multiply -> stack.push(operand1 * operand2);
                        case Divide -> stack.push(operand1 / operand2);
                        case Power -> stack.push(Math.pow(operand1, operand2));
                    }
                    break;
                case Function:
                    Double operand = stack.pop();
                    switch (token.asFunction) {
                        case Sin -> stack.push(Math.sin(operand));
                        case Cos -> stack.push(Math.cos(operand));
                        case Exp -> stack.push(Math.exp(operand));
                    }
                    break;
            }
        }
        return stack.pop();
    }
}