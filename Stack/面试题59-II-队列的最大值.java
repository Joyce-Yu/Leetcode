package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new ArrayDeque<>();
    }

    public int max_value() {
        if (deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();

    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value){
            deque.pollLast();
        }
        queue.offer(value);
        deque.offerLast(value);

    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        if (queue.peek().equals(deque.peekFirst())){
            deque.pollFirst();
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        int param_1 = maxQueue.max_value();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        maxQueue.push_back(3);
        int param_2 = maxQueue.pop_front();
        int param_3= maxQueue.max_value();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
