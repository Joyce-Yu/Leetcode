package com.nice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author: Chenbing
 * @date: 2021.01.16 14:53
 * @description: 347.前 K 个高频元素
 */
public class leetcode_0347_top_k_frequent_elements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int count = map.getOrDefault(nums[i],0) + 1;
            map.put(nums[i],count);
        }

        //注意override compare函数
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key : map.keySet()){
            if (queue.size() < k){
                queue.offer(key);
            } else if (map.get(key) > map.get(queue.peek())){
                queue.poll();
                queue.offer(key);
            }
        }

        int[] res = new int[k];
        int index = 0;
        for (int i: queue){
            System.out.println(i);
            res[index++] = i;
        }

        return res;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1,0};
        int k = 1;
        leetcode_0347_top_k_frequent_elements leetcode_0347_top_k_frequent_elements = new leetcode_0347_top_k_frequent_elements();
        System.out.println(leetcode_0347_top_k_frequent_elements.topKFrequent(nums, k));
    }
}
