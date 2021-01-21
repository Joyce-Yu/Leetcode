package com.nice;

import java.util.Arrays;

/**
 * @author: Chenbing
 * @date: 2021.01.21 14:13
 * @description:
 */
public class leetcode_0912_SortanArray {

    public int[] sortArray(int[] nums) {
        return quickSort(nums, 0, nums.length-1);

    }

    private int[] quickSort(int[] nums, int left, int right){
        if (left > right || left < 0 || right < 0){
            return new int[]{};
        }
        int low = left;
        int high = right;
        int privot = nums[low];
        while (low < high){
            while (low < high && privot <= nums[high]){
                high--;
            }
            if (low < high){
                nums[low] = nums[high];
                low++;
            }

            while (low < high && privot > nums[low]){
                low++;
            }
            if (low < high){
                nums[high] = nums[low];
                high--;
            }
        }
        nums[low] = privot;
        quickSort(nums, left, low-1);
        quickSort(nums, low+1, right);

        return nums;

    }

    public static void main(String[] args) {
        leetcode_0912_SortanArray leetcode_0912_sortanArray = new leetcode_0912_SortanArray();
        int[] nums = {5,2,3,6,4,9,8,0,7};
        int[] res = leetcode_0912_sortanArray.sortArray(nums);
        System.out.println(Arrays.toString(res));

    }


}
