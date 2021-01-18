package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.18 15:14
 * @description: 42题.接雨水
 */
public class leetcode_0042_TrappingRainWater {
    public int trap(int[] height) {
        int length = height.length;
        int i = 1;
        int sum = 0;
        for (int j = i-1 ; j < length - 1; j++){
            //找到左边最大的
            int max_left = 0, max_right = 0;
            for (int k = j - 1; k >= 0; k--){
                if (height[k] > max_left){
                    max_left = height[k];
                }
            }

            //找到右边最大的
            for (int p = j + 1; p < length;p++){
                if (height[p] > max_right){
                    max_right = height[p];
                }
            }

            //从左右的最大，选出一个较小的
            int min = Math.min(max_left, max_right);

            //当最小的依然小于当前的高度，加到sum中
            if (min > height[j]){
                sum += (min - height[j]);
            }
        }
        return sum;

    }

    /**方法二 动态规划
     * 相比于上一种，主要改变了左侧最大和右侧最大的解法
     *
     * 对于 max_left我们其实可以这样求。
     * max_left [i] = Max(max_left [i-1],height[i-1])。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
     *
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
     * **/
    public int trap2(int[] height) {
        int length = height.length;
        int[] max_left = new int[length];
        int[] max_right = new int[length];

        int sum = 0;

        for (int i = 1; i < length - 1; i++){
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        }

        for (int i = length - 2; i >= 0; i--){
            max_right[i] = Math.max(max_right[i+1],height[i+1]);
        }

        for (int i = 1; i < length-1; i++){
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]){
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,2};
        leetcode_0042_TrappingRainWater leetcode_0042_trappingRainWater = new leetcode_0042_TrappingRainWater();
        System.out.println(leetcode_0042_trappingRainWater.trap(nums));
    }
}
