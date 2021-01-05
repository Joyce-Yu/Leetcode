package com.nice;
/**此题是33题的进阶
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * BY Joyce, 参考https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/
 *
 * 思路：
 * 有重复的分三种情况：
 * 1。 10111 和 1110111101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项
 * 2。 2345671 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
 * 这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
 * 3。 6712345 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
 * 这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找
 *
 */

/**题目描述
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,0,1,2,2,5,6] 经旋转后可能变为[2,5,6,0,0,1,2] ）。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false
 * 相比于33题，本题中的 nums  可能包含重复元素。
 *
 */
class Solution81 {

    public boolean search(int[] nums, int target) {
        int length = nums.length;

        /**判断特例**/
        if (length == 0){
            return false;
        }
        if (length == 1){
            return  nums[0] == target ? true : false;
        }

        /**声明l，r**/
        int l = 0;
        int r = length - 1;

        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                return true;
            }
            /**排除第一种情况**/
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }

            /**第二种情况，前半部分有序 **/
            if (nums[l] < nums[mid]){
                /**如果nums[l] <target<=nums[mid]，在前半部分找；否则，在后半部分找 **/
                if (nums[mid] > target && nums[l] <= target){
                    r = mid - 1;
                } else{
                    l = mid + 1;
                }
            } else {/**第三种情况，后半部分有序 **/
                /**如果nums[mid] <target<=nums[r]，在后半部分找；否则，在前半部分找 **/
                if (nums[mid] < target && nums[r] >= target){
                    l = mid + 1;
                } else{
                    r = mid - 1;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Solution81 solution81 = new Solution81();
        int[] nums = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 13;
        System.out.println(solution81.search(nums, target));
    }
}
