package week02;

import week01.Queue;

public interface IShuntingYardAlgorithm {
    Queue<Token> convertToRPN(Queue<Token> input);
}
