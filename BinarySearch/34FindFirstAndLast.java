/*
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
By Joyce
需要注意：
  findLastPosition方法，int mid = left + (right - left + 1) / 2; 如果没有+1，会出现死循环。
  具体可看liweiwei讲解https://leetcode-cn.com/leetbook/read/learning-algorithms-with-leetcode/xs41qg/
*/
package com.nice;

/**
 * @author Chenbing
 */
class Solution34{
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;

        if (len == 0){
            return new int[]{-1, -1};
        }

        int first = findFirstPosition(nums, target);
        if (first == -1){
            return new int[]{-1, -1};
        }
        int last = findLastPosition(nums, target);
        System.out.println(first);
        System.out.println(last);
        return new int[]{first, last};
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else{
                left = mid;
                //right = mid;
            }
        }
        return left;

    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else{
                right = mid;
            }
        }
        if (nums[left] == target){
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = {2,7,7};
        int target = 7;
        System.out.println(solution34.searchRange(nums, target));
    }

}
