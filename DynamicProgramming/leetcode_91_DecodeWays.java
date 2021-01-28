package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.28 11:01
 * @description:
 */
public class leetcode_91_DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0)=='0'){
            return 0;
        }

        //dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'? 0 : 1;

        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == '0'){
                if (s.charAt(i-1) == '1' || s.charAt(i-1) =='2'){
                    dp[i+1] = dp[i-1];
                }else{
                    return 0;
                }
            }
            if (s.charAt(i) != '0'){
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) < '7'){
                    dp[i+1] = dp[i-1] + dp[i];
                } else{
                    dp[i+1] = dp[i];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        leetcode_91_DecodeWays leetcode_91_decodeWays = new leetcode_91_DecodeWays();
        System.out.println(leetcode_91_decodeWays.numDecodings("2623"));
    }
}
