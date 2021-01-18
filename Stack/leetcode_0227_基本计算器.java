package com.nice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Chenbing
 * @date: 2021.01.18 20:27
 * @description:
 */
public class leetcode_0227_BasicCalculatorII {
    public int calculate(String s) {
        s = s.trim();

        Deque<Integer> stack = new ArrayDeque<>();

        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                continue;
            }

            if (Character.isDigit(c)){
                num = 10 * num + (c - '0');
            }

            //重要！当遍历到最后一个数字的时候也需要计算！
            //这边的sign是前一次的sign！！
            if (!Character.isDigit(c) || i == s.length() - 1){
                switch (sign){
                    case '+':
                        stack.offerLast(num);
                        break;
                    case '-':
                        stack.offerLast(-num);
                        break;
                    case '*':
                        int a = stack.pollLast();
                        stack.offerLast(a*num);
                        break;
                    case '/':
                        int b = stack.pollLast();
                        stack.offerLast(b / num);
                        break;
                }

                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pollLast();
        }

        return res;

    }

    public static void main(String[] args) {
        leetcode_0227_BasicCalculatorII leetcode_0227_basicCalculatorII = new leetcode_0227_BasicCalculatorII();
        System.out.println(leetcode_0227_basicCalculatorII.calculate("4+7-3/2*3"));


    }
}
