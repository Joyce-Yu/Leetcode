/*
leetcode：https://leetcode-cn.com/problems/search-insert-position/
by Joyce
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。

注意：和704的差异在于，最后返回的是left

*/

package com.nice;

class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else{
                return mid;
            }
        }

        return left;

    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(s.searchInsert(nums, target));
    }
}
