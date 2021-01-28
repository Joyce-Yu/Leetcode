package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.26 13:08
 * @description:
 */
public class leetcode_494_TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0){
            return 0;
        }

        int sum = 0;
        for (int num: nums){
            sum += num;
        }

        if (S > sum){
            return 0;
        }
        if ((S + sum) % 2 != 0){
            return 0;
        }

        int target = (S + sum) / 2;
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++){
            for (int j = target; j >= nums[i]; j--){
                dp[j] += dp[j-nums[i]];
            }
        }

        return dp[target];

    }

    public static void main(String[] args) {
        leetcode_494_TargetSum leetcode_494_targetSum = new leetcode_494_TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int s = 3;
        System.out.println(leetcode_494_targetSum.findTargetSumWays(nums, s));
    }
}
