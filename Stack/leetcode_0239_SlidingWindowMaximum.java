package com.nice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Chenbing
 * @date: 2021.01.19 13:33
 * @description:
 */
public class leetcode_0239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        if (nums.length < k){
            return res;
        }

        for (int i = 0; i < k; i++){
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);

            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1){
                queue.pollFirst();
            }
        }
        res[0] = nums[queue.peekFirst()];

        for (int i = k; i < nums.length; i++){
            // 如果queue已有元素
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);

            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1){
                queue.pollFirst();
            }

            res[i-k+1] = nums[queue.peekFirst()];

        }

        for (int re: res){
            System.out.println(re);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,5,8,6,-4,-2,-1,2,4};
        int k = 3;
        leetcode_0239_SlidingWindowMaximum leetcode_0239_slidingWindowMaximum = new leetcode_0239_SlidingWindowMaximum();
        leetcode_0239_slidingWindowMaximum.maxSlidingWindow(nums, k);
    }
}
