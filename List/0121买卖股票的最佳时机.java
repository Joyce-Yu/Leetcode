package com.nice;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * by Joyce
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 */
class Solution121{

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minProfit = Integer.MAX_VALUE;

        for (int price: prices){
            if (price < minProfit){
                minProfit = price;
            } else if (price - minProfit > maxProfit){
                maxProfit = price - minProfit;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int[] nums = new int[]{7,6,4,3,1};
        System.out.println(solution121.maxProfit(nums));

    }
}
