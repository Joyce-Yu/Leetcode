package com.nice;
/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * BY Joyce,参考https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
 * 题目思路
 * 由于题目说数字了无重复，举个例子：
 * 1 2 3 4 5 6 7 可以大致分为两类，
 * 第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
 * 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
 * 第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
 * 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。
 *
*/

/**题目描述
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为[4,5,6,7,0,1,2] ）。
 * 请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 *
 */

class Solution33 {

    public int search(int[] nums, int target) {
        int length = nums.length;

        /**判断特例**/
        if (length == 0){
            return -1;
        }
        if (length == 1){
            return  nums[0] == target ? 0 : -1;
        }

        /**声明l，r**/
        int l = 0;
        int r = length - 1;

        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[l] <= nums[mid]){
                if (target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                } else{
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] nums = {6, 7, 3};
        int target = 3;
        System.out.println(solution33.search(nums, target));
    }
}
