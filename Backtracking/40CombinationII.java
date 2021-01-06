/**
 * 题目链接：https://leetcode-cn.com/problems/combination-sum-ii/
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * (和39题的区别，candidates可以重复，res中每个candidate只能用一次）
 * By Joyce
 */

package com.nice;

import java.util.*;

class Solution40 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        Arrays.fill(used, Boolean.FALSE);
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, used);
        return res;

    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used){
        if (sum > target){
            return;
        }
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++){
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false){
                continue;
            }
            sum += candidates[i];
            path.addLast(candidates[i]);
            used[i] = true;
            backtracking(candidates, target, sum, i+1, used);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();

        }

    }

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(solution40.combinationSum2(candidates, target));
    }
}
