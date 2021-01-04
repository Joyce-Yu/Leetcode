/*
https://leetcode-cn.com/problems/validate-binary-search-tree/
by Joyce
设计一个递归函数 helper(root, lower, upper) 来递归判断，函数表示考虑以 root 为根的子树，判断子树中所有节点的值是否都在 (l,r) 的范围内
在递归调用左子树时，我们需要把上界 upper 改为 root.val， 调用右子树时，需把下届lower改为root.val
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);

    }
    public boolean helper(TreeNode root, Integer lower, Integer upper){
        if (root == null) return true;
        int val = root.val;
        if (lower != null && val <= lower){
            return false;
        }
        if (upper != null && val >= upper){
            return false;
        }
        return helper(root.right, val, upper) && helper(root.left, lower, val);

    }
}
