/**
 * https://leetcode-cn.com/problems/combination-sum/
 * by Joyce
 *
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 *
 **/

package com.nice;

import java.util.*;

class Solution39 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target)     {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex){
        if (sum > target){
            return;
        }
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; (i < candidates.length) && (sum+candidates[i] <= target); i++){
            sum += candidates[i];
            path.addLast(candidates[i]);
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution39  solution39 = new Solution39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(solution39.combinationSum(candidates, target));
    }
}
