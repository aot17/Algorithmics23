package week02;

import week01.Queue;
import week01.Stack;

public class ShuntingYardAlgorithm implements IShuntingYardAlgorithm {
    @Override
    public Queue<Token> convertToRPN(Queue<Token> input) {
        Queue<Token> outputQueue = new Queue<>(99);
        Stack<Token> operatorStack = new Stack<>(99);

        for (Token token : input) {
            switch (token.type) {
                case Numeric -> outputQueue.enqueue(token);
                case Function -> operatorStack.push(token);
                case Operator -> {
                    while ((!operatorStack.isEmpty() && operatorStack.peek().asBracket != Token.Bracket.Open) &&
                            (operatorStack.peek().getOperatorPrecedence() > token.getOperatorPrecedence() ||
                                    (operatorStack.peek().getOperatorPrecedence() == token.getOperatorPrecedence() &&
                                            token.asOperator != Token.OperatorType.Power))) {
                        outputQueue.enqueue(operatorStack.pop());
                    }
                    operatorStack.push(token);
                }
                case Bracket -> {
                    if (token.asBracket == Token.Bracket.Open) {
                        operatorStack.push(token);
                    } else if (token.asBracket == Token.Bracket.Close) {
                        while (operatorStack.peek().asBracket != Token.Bracket.Open) {
                            outputQueue.enqueue(operatorStack.pop());
                        }
                        operatorStack.pop();
                        if (operatorStack.peek().type == Token.TokenType.Function) {
                            outputQueue.enqueue(operatorStack.pop());
                        }
                    }
                }
            }
        }
        for (Token token : operatorStack) {
            outputQueue.enqueue(operatorStack.pop());
        }
        return outputQueue;
    }
}