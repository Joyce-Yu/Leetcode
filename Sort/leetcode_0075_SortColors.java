package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.21 16:21
 * @description:
 */
public class leetcode_0075_SortColors {

    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length-1);
        for (int num: nums){
            System.out.println(num);
        }
    }

    public void sort(int[] nums, int i, int j){
        int low = i;
        int high = j;
        if (low > high){
            return;
        }
        //用列表的第一个数据作为pivot
        int pivot = nums[low];
        while (low < high){
            while (low < high && nums[high] >= pivot){
                high--;
            }
            // 用比基准小的记录替换低位记录
            if (low < high){
                nums[low] = nums[high];
                low++;
            }
            while (low < high && nums[low] < pivot){
                low++;
            }
            // 用比基准大的记录替换高位记录
            if (low < high){
                nums[high] = nums[low];
                high--;
            }
        }
        nums[low] = pivot;
        sort(nums,i, low-1);
        sort(nums, low+1, j);
    }

    public static void main(String[] args) {
        leetcode_0075_SortColors leetcode_0076_sortColors = new leetcode_0075_SortColors();
        int[] nums = new int[]{0};
        leetcode_0076_sortColors.sortColors(nums);
    }
}
