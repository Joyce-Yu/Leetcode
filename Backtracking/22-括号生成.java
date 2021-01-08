package com.nice;
/**
 * link:https://leetcode-cn.com/problems/generate-parentheses/
 * by Joyce
 */

import java.util.ArrayList;
import java.util.List;


class Solution22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backtracking(n,0,0, new StringBuilder());
        return res;
    }

    private void backtracking(int n, int open, int close, StringBuilder s){
        if (s.length() == 2 * n){
            res.add(s.toString());
            return;
        }
        if (open < n){
            s.append('(');
            backtracking(n, open+1, close, s);
            s.deleteCharAt(s.length()-1);
        }
        if (open > close){
            s.append(')');
            backtracking(n, open, close+1, s);
            s.deleteCharAt(s.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(1));
    }
}
