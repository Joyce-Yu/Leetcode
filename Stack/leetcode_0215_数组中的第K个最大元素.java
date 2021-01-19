package com.nice;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: Chenbing
 * @date: 2021.01.19 17:29
 * @description:
 */
public class leetcode_0215_KthLargestElementinanArray {
    /**方法一**/
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length-k];
    }

    /**方法二**/
    public int findKthLargest2(int[] nums, int k) {
        int length = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(length,(v1,v2)->v1-v2);
        for (int i = 0; i < length; i++){
            pq.add(nums[i]);
        }

        for (int i = 0; i < length - k; i++){
            pq.poll();
        }
        return pq.peek();
    }



    public static void main(String[] args) {
        leetcode_0215_KthLargestElementinanArray leetcode_0215_kthLargestElementinanArray = new leetcode_0215_KthLargestElementinanArray();
        System.out.println(leetcode_0215_kthLargestElementinanArray.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
