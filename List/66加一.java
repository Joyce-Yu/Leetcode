package com.nice;

/**
 * link：https://leetcode-cn.com/problems/plus-one/
 * BY Joyce
 * 1. for循环从最后一位开始，逐渐往前
 *      如果digits[i] % 10 不为0，则可以直接返回结果（比如123->124的情况)
 *      如果为0， 则继续for循环前一位（比如129->130的情况）
 *      如果for循环结束了（比如999的情况），则新建一个数组，只要将首位设置为1就ok
 */
class Solution66 {
    public int[] plusOne(int[] digits) {
       for (int i = digits.length-1; i >=0; i--){
           digits[i]++;
           digits[i] = digits[i] % 10;
           if (digits[i] != 0){
               return digits;
           }
       }
       digits = new int[digits.length+1];
       digits[0] = 1;
       return digits;
    }

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        int[] res = solution66.plusOne(new int[] {9,9,9});
        for(int x: res){
            System.out.println(x);
        }
    }
}
