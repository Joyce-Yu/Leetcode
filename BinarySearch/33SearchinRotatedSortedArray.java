package com.nice;
/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * BY Joyce,详细见注释
 */

/**
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

            /**判断target是在哪一段，可能是前面，可能后面**/
            if (nums[0] <= target){
                //在左半段，分情况
                // 1. mid也在左边
                //  1.1 mid比target小
                //  1.2 mid比target大
                // 2. mid在右边，直接 r = mid - 1；
                if (nums[mid] >= nums[0]){
                    if (nums[mid] < target){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                } else{
                    r = mid - 1;
                }

            } else{
                //在右半段，分情况
                // 1. mid在左边，直接 l = mid + 1；
                // 2. mid在右边，
                // 2.1 mid比target小
                // 2.2 mid比target大
                if (nums[mid] >= nums[0]){
                    l = mid + 1;
                }else{
                    if (nums[mid] < target){
                        l = mid + 1;
                    } else{
                        r = mid - 1;
                    }
                }

            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] nums = {1,2};
        int target = 3;
        System.out.println(solution33.search(nums, target));
    }
}
