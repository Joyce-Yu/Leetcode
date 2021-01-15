package 剑指offer;

import java.util.HashMap;

/**
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *  找出数组中重复的数字。
 *  在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 */
class Solution03 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                return nums[i];
            }
            map.put(nums[i],i);
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
