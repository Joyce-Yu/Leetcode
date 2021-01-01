/*
leetcode:https://leetcode-cn.com/problems/diameter-of-binary-tree/
by Joyce

给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。



*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        if (root == null){
            return 0;
        }
        helper(root);
        return ans;

    }

    public int helper(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        ans = Math.max(left+right, ans);
        
        //这边return的是总的节点数，而ans存的是最大的直径（直径比总节点数-1）
        return Math.max(left, right)+1;
        
    }
}
