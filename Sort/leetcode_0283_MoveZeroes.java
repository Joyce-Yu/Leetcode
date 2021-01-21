package com.nice;

/**
 * @author: Chenbing
 * @date: 2021.01.21 15:15
 * @description: 283.移动零（简单）
 */
public class leetcode_0283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2){
            return;
        }

        int next = 0;
        for (int j = 0; j < nums.length ; j++){
            if (nums[j] != 0){
                nums[next] = nums[j];
                next++;
            }
        }
        for (int k = next; k < nums.length; k++){
            nums[k] = 0;
        }

    }

    public static void main(String[] args) {
        leetcode_0283_MoveZeroes leetcode_0283_moveZeroes = new leetcode_0283_MoveZeroes();
        int[] nums = new int[]{2,3,0,5,7,0,8};
        leetcode_0283_moveZeroes.moveZeroes(nums);
    }
}
