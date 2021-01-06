/**
 * link: https://leetcode-cn.com/problems/permutations-ii/
 * By Joyce
 */
package com.nice;

import java.util.*;
import java.util.List;

class Solution47 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
           //和46题的区别
            if (i > 0 && nums[i]==nums[i-1] && used[i-1] == false){
                continue;
            }
            if (used[i] == true){
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtracking(nums, used);
            used[i] = false;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[] nums = {1, 1, 2};
        System.out.println(solution47.permuteUnique(nums));
    }

}
