package com.nice;
/**
 * https://leetcode-cn.com/problems/subsets
 * by Joyce
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

class Solution78 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();


    public List<List<Integer>> subsets(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, 0, used);
        return res;
    }

    private void backtracking(int[] nums, int startIndex, boolean[] used){
        res.add(new ArrayList<>(path));

        for(int i = startIndex; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtracking(nums, i+1, used);
            used[i] = false;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        Solution78 solution78 = new Solution78();
        System.out.println(solution78.subsets(nums));

    }
}
