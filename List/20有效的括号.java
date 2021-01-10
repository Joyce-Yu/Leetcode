package com.nice;
/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 示例1
 * 输入: "(]"
 * 输出: false
 * 示例2
 * 输入: "([)]"
 * 输出: false
 * 示例3
 * 输入: "{[]}"
 * 输出: true
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution20{
    public boolean isValid(String s) {
        //记得初始大小
        Map<Character, Character> map = new HashMap<>(3);
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        if (s.length()==0){
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>(){};

        for (Character c: s.toCharArray()){
            if (map.containsKey(c)){
                //别忘记这个stack.isEmpty()条件，如果为空，则可以直接判断为false
                if (stack.isEmpty() || !stack.peekLast().equals(map.get(c))){
                    return false;
                }
                stack.pollLast();
            } else{
                stack.offerLast(c);
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("{[]}"));
    }
}
