/**
 * link:https://leetcode-cn.com/problems/subsets-ii
 * by Joyce
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 注意：求取子集问题，不需要任何剪枝！因为子集就是要遍历整棵树
 */
package com.nice;

import java.util.*;

class Solution90 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums,0, used);
        return res;

    }
    private void backtracking(int[] nums, int startIndex, boolean[] used){
        res.add(new ArrayList<>(path));

        for(int i = startIndex; i < nums.length; i++){
            if (i > 0 && nums[i-1] == nums[i] && used[i-1]==false){
                continue;
            }
            if(used[i]){
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
        int nums[] = {1, 2, 2};
        Solution90 solution90 = new Solution90();
        System.out.println(solution90.subsetsWithDup(nums));

    }
}
