package com.nice;
/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * By Joyce
 */

import java.util.ArrayList;
import java.util.List;

class Solution17 {
    String[] letterMap = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder s = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return res;
        }

        backtracking(digits,0);
        return res;
    }

    private void backtracking(String digits, int index){
        if (index == digits.length()){
            res.add(new String(s));
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = letterMap[digit];

        for(int i = 0; i < letters.length(); i++){
            s.append(letters.charAt(i));
            backtracking(digits, index+1);
            s.deleteCharAt(s.length()-1);
        }

    }

    public static void main(String[] args) {
        String digits = "23";
        Solution17 solution17 = new Solution17();

        System.out.println(solution17.letterCombinations(digits));
    }
}
