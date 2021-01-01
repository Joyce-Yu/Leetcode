/*
leetcode:https://leetcode-cn.com/problems/balanced-binary-tree/
by Joyce
本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) 
            return true;
        return check(root)!=-1;
    }

    public int check(TreeNode root){
        if (root == null)
            return 0;
            
        int left = check(root.left);
        if (left == -1) 
            return -1;
       
        int right = check(root.right);
        if (right == -1)
            return -1;

        return Math.abs(left-right)<=1 ? Math.max(left,right)+1: -1;
    }
}
