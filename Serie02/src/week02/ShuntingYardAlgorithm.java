package week02;

import week01.Queue;
import week01.Stack;

public class ShuntingYardAlgorithm implements IShuntingYardAlgorithm {

    @Override
    public Queue<Token> convertToRPN(Queue<Token> input) {
        Stack<Token> ops = new Stack<>(99);
        Queue<Token> out = new Queue<>(999);

        for (Token token : input) {
            switch (token.type) {
                case Numeric:
                    out.enqueue(token);
                    break;
                case Operator:
                    while (!ops.isEmpty() &&
                            ops.peek().type == Token.TokenType.Operator &&
                            token.getOperatorPrecedence() <= ops.peek().getOperatorPrecedence()) {
                        out.enqueue(ops.pop());
                    }
                    ops.push(token);
                    break;
                case Function:
                    ops.push(token);
                    break;
                case Bracket:
                    if (token.asBracket == Token.Bracket.Open) {
                        ops.push(token);
                    } else {
                        while (ops.peek().type != Token.TokenType.Bracket) {
                            out.enqueue(ops.pop());
                        }
                        ops.pop();
                        if (!ops.isEmpty() && ops.peek().type == Token.TokenType.Function) {
                            out.enqueue(ops.pop());
                        }
                    }
                    break;
            }
        }

        while (!ops.isEmpty()) {
            out.enqueue(ops.pop());
        }

        return out;
    }
}
