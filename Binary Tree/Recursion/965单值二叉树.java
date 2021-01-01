/*
leetcode: https://leetcode-cn.com/problems/univalued-binary-tree/
By Joyce
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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return true;
        }
        return helper(root, root.val);

    }

    public boolean helper(TreeNode root, int target){
        if (root == null){
            return true;
        }
        return root.val==target && helper(root.left, target) && helper(root.right, target);
    }
}
