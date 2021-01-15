package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.15 19:49
 * @description: 204. 计数质数  可以用厄拉多塞筛法
 */
public class leetcode_0204_Count_Primes {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        int count = 0;

        boolean[] sign = new boolean[n];
        for (int i = 2; i < n; i++){
            if (!sign[i]){
                count++;
            }
            for (int j = i + i; j < n; j += i){
                sign[j] = true;
            }
        }
        return count;

    }

    public static void main(String[] args) {

    }

}
