package com.nice;
/**
 * LINK:https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * By Joyce
 */

import java.util.ArrayList;
import java.util.List;

class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0){
                nums[newIndex] *= -1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution448 solution448 = new Solution448();
        int[] nums = new int[]{1,2,4,2,4};
        System.out.println(solution448.findDisappearedNumbers(nums));

    }
}
