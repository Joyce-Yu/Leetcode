package com.nice;
/**
 * https://leetcode-cn.com/problems/increasing-subsequences
 * by Joyce
 */

import java.util.*;

class Solution491 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex){
        //System.out.println(path);
        if (path.size() > 1){
            res.add(new ArrayList<>(path));
        }
        //用到set去重
        Set<Integer> set = new HashSet<>();

        for(int i = startIndex; i < nums.length; i++){
            //1.如果set里已经有该值了说明 加上 nums[i] 后的所有可能的递增序列之前已经被搜过一遍了
            if (set.contains(nums[i])) {
                continue;
            }
            //2.如果num[i] 小于path的最后一个数字，说明不是递增序列，跳过
            if (path.size()!=0 && nums[i] < path.getLast()){
               continue;
            }
            set.add(nums[i]);
            path.addLast(nums[i]);
            backtracking(nums, i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution491 solution491 = new Solution491();
        int[] nums = {4, 6, 7};
        System.out.println(solution491.findSubsequences(nums));
    }
}
