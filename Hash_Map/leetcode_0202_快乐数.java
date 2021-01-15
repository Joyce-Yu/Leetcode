package com.nice;

import java.util.HashSet;

/**
 * @author: Chenbing
 * @date: 2021.01.15 17:51
 * @description:
 */
public class leetcode_0202_Happy_Number {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true){

            int sum = getSum(n);

            if (sum == 1){
                return true;
            }
            if (set.contains(sum)){
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
    }

    public int getSum(int n){
        int sum = 0;
        while (n != 0){
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        leetcode_0202_Happy_Number leetcode_0202_happy_number = new leetcode_0202_Happy_Number();
        System.out.println(leetcode_0202_happy_number.isHappy(2));
    }

}
