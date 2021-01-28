package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.26 11:08
 * @description:
 */
public class leetcode_0416_PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0){
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;

        int[] dp = new int[sum+1];

        for (int i = 0; i < nums.length; i++){
            for (int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }

        if (dp[target] == target){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        leetcode_0416_PartitionEqualSubsetSum leetcode_0416_partitionEqualSubsetSum = new leetcode_0416_PartitionEqualSubsetSum();
        System.out.println(leetcode_0416_partitionEqualSubsetSum.canPartition(nums));
    }
}
