package com.nice;
/**
 * link:https://leetcode-cn.com/problems/binary-tree-paths
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */

import java.util.ArrayList;
import java.util.List;

//public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

class Solution257 {
    List<String> res= new ArrayList<>();
    //StringBuilder s = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return res;
        }
        backtracking(root, "");
        return res;

    }

    private void backtracking(TreeNode root, String s){
        if (root == null){
            return;
        }
        StringBuilder path = new StringBuilder(s);
        path.append(root.val);
        if (root.left == null && root.right == null){
            res.add(path.toString());
        } else{
            path.append("->");
            backtracking(root.left, path.toString());
            backtracking(root.right, path.toString());
        }

       // s.deleteCharAt(-1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.left = node4;
        node3.right = node6;
        Solution257 solution257 = new Solution257();
        List<String> binaryTreePaths = solution257.binaryTreePaths(node1);
        binaryTreePaths.forEach(System.out::println);
    }








}
