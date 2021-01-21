package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.21 14:33
 * @description: 26,删除排序数组中的重复项（需原地修改）
 * ！注意此题最后数组长度依然没有改变
 */
public class leetcode_0026_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }

        for (int num: nums){
            System.out.println(num);
        }
        return i+1;

    }

    public static void main(String[] args) {
        leetcode_0026_RemoveDuplicatesfromSortedArray leetcode_0026_removeDuplicatesfromSortedArray = new leetcode_0026_RemoveDuplicatesfromSortedArray();
        int[] nums = new int[]{1,4,4,5,5,7,8};
        System.out.println(leetcode_0026_removeDuplicatesfromSortedArray.removeDuplicates(nums));
    }
}
