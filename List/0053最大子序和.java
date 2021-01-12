package com.nice;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * BY Joyce
 */
class Solution53{
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int sum = 0;
        int ans = nums[0];

        for (int num: nums){
            if (sum > 0){
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution53.maxSubArray(nums));
    }
}
