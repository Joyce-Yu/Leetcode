package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.21 14:41
 * @description: 27.移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不能使用额外的空间
 */
public class leetcode_0027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return -1;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
