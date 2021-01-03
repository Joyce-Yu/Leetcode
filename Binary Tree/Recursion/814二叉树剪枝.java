/*
leetcode: https://leetcode-cn.com/problems/binary-tree-pruning/
by Joyce
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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null){
            return null;
        }
        return containOne(root)? root:null;

    }

    public boolean containOne(TreeNode root){
        if (root == null){
            return false;
        }
        
        /***后序遍历***/
        boolean l = containOne(root.left);
        boolean r = containOne(root.right);
        
        //如果不包含1，则返回null（相当于剪支了）
        if (!l) root.left = null;
        if (!r) root.right = null;
        
        //如果左右子树含有1 或者根节点有1，则返回true；
        return root.val == 1 || l || r;
    }
}
