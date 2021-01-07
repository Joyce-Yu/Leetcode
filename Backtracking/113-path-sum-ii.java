package com.nice;
/**
 * link:https://leetcode-cn.com/problems/path-sum-ii/
 * by Joyce
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution113 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return res;
        }
        backtracking(root, sum);
        return res;

    }

    private void backtracking(TreeNode root, int target){
        if (root == null){
            return;
        }
        path.addLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target==0){
            res.add(new ArrayList<>(path));
        }
        backtracking(root.left, target);
        backtracking(root.right, target);
        //sum -= root.val;
        path.removeLast();

    }

    public static void main(String[] args) {

    }
}
