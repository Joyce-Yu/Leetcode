/*
https://leetcode-cn.com/problems/flip-equivalent-binary-trees/
by Joyce

如果根相等，满足下面两种条件之一就是翻转相等二叉树。
a) 树1的左子树和树2的左子树，及树1右子树及树2的右子树递归翻转相等
b) 树1的左子树和树2的右子树，及树1右子树及树2的左子树递归翻转相等
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null || root1.val!=root2.val){
            return false;
        }

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right)&&flipEquiv(root1.right, root2.left));    
    }
}
