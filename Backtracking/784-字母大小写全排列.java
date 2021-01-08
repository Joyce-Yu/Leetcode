package com.nice;
/**
 * 涉及大小写的转化，字符串转字符数字
 * link：https://leetcode-cn.com/problems/letter-case-permutation/
 * by Joyce
 */

import java.util.ArrayList;
import java.util.List;

class Solution784 {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        char[] arrays = S.toCharArray();
        backtracking(arrays, 0);
        return res;
    }

    private void backtracking(char[] arrays, int startIndex){
        if(startIndex == arrays.length){
            res.add(new String(arrays));
            return;
        }
        backtracking(arrays, startIndex+1 );
        if (Character.isLetter(arrays[startIndex])){
            //这边是大小写的转换
            arrays[startIndex] ^= 1 << 5;
            backtracking(arrays, startIndex+1);
            //经检验下面这步骤可以删去，原因是每个字母只有两种情况
            //arrays[startIndex] ^= 1 >> 5;
        }

    }

    public static void main(String[] args) {
        Solution784 solution784 = new Solution784();
        System.out.println(solution784.letterCasePermutation("a1b2"));
    }
}
