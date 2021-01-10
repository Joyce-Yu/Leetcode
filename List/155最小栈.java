package com.nice;
/**
 * https://leetcode-cn.com/problems/min-stack/submissions/
 * by Joyce
 * 用Deque实现stack的话，记得全程last！比如offerLast(), peekLast(),pollLast(),etc..
 */

import java.util.Deque;
import java.util.LinkedList;

class Solution155 {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    /** initialize your data structure here. */
    public Solution155() {
        //一个数据栈，一个辅助栈（记得先存一个最大值）
        stack = new LinkedList<>();
        minStack = new LinkedList<>(){{offerLast(Integer.MAX_VALUE);}};

    }

    public void push(int x) {
        stack.offerLast(x);
        if (x < minStack.peekLast()){
            minStack.offerLast(x);
        } else {
            minStack.offerLast(minStack.peekLast());
        }
    }

    public void pop() {
        //这边要同步pollLast()哦！！
        stack.pollLast();
        minStack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return minStack.peekLast();
    }

    public static void main(String[] args) {
        Solution155 solution155 = new Solution155();
        solution155.push(1);
        solution155.push(5);
        solution155.push(10);
        solution155.push(20);
        solution155.pop();
        solution155.pop();
        System.out.println(solution155.top());
        System.out.println(solution155.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
