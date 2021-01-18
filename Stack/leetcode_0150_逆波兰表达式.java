package com.nice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Chenbing
 * @date: 2021.01.18 19:54
 * @description:
 */
public class leetcode_0150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0){
            return -1;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens){
            switch (token){
                case "+":
                    stack.offerLast(stack.pollLast()+stack.pollLast());
                    break;

                case "-":
                    stack.offerLast(-stack.pollLast()+stack.pollLast());
                    break;
                case "*":
                    stack.offerLast(stack.pollLast()*stack.pollLast());
                    break;
                case "/":
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.offerLast(b / a);
                    break;
                default:
                    stack.offerLast(Integer.parseInt(token));

            }
        }
        return stack.pollLast();

    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        leetcode_0150_EvaluateReversePolishNotation leetcode_0150_evaluateReversePolishNotation = new leetcode_0150_EvaluateReversePolishNotation();
        System.out.println(leetcode_0150_evaluateReversePolishNotation.evalRPN(tokens));

    }
}
