package com.nice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: Chenbing
 * @date: 2021.01.15 20:01
 * @description: 给定两个数组，编写一个函数来计算它们的交集。
 *  示例：
 *  输入：nums1 = [1,2,2,1], nums2 = [2,2]
 *  输出：[2,2]
 */
public class leetcode_0350_Intersection_of_Two_ArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int num: nums1){
            int count = map1.getOrDefault(num, 0) + 1;
            map1.put(num, count);
        }

        int[] intersection = new int[nums1.length];

        int index = 0;
        for (int num: nums2){
            int count = map1.getOrDefault(num, 0);
            if (count > 0){
                intersection[index++] = num;
                count--;
                if (count > 0){
                    map1.put(num, count);
                } else {
                    map1.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(intersection, 0, index);

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{2};
        int[] num2 = new int[]{2,3,4};
        leetcode_0350_Intersection_of_Two_ArraysII leetcode_0350_intersection_of_two_arraysII = new leetcode_0350_Intersection_of_Two_ArraysII();
        int[] res = leetcode_0350_intersection_of_two_arraysII.intersect(num1, num2);
        for (int re: res){
            System.out.println(re);
        }

    }
}
