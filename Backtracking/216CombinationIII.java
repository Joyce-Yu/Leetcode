/**
 * link: https://leetcode-cn.com/problems/combination-sum-iii/
 * By Joyce
 **/
package com.nice;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


class Solution216 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 0, 1);
        return res;
    }

    private void backtracking(int targetSum, int k, int sum, int startIndex){
        if (sum > targetSum){
            return;
        }
        if (path.size() == k){
            if (sum == targetSum){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++){
            sum += i;
            path.addLast(i);
            backtracking(targetSum, k, sum, i+1);
            sum -= i;
            path.removeLast();

        }
    }

    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        System.out.println(solution216.combinationSum3(2, 4));
    }
}
