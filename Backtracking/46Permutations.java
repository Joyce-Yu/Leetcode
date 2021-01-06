package com.nice;
/**
 * https://leetcode-cn.com/problems/permutations/
 * by Joyce
 * 需要注意：
 * 每层都是从0开始搜索而不是startIndex
 * 需要used数组记录path里都放了哪些元素了
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution46 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    //参数不需要有startIndex，直接用used布尔数组
    private void backtracking(int[] nums, boolean[] used){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (used[i]){
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
        Solution46 solution46 = new Solution46();
        int[] nums = {1,2,3};
        System.out.println(solution46.permute(nums));
    }
}
