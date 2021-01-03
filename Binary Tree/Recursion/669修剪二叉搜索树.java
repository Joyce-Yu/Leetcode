/*
leetcode:https://leetcode-cn.com/problems/trim-a-binary-search-tree/
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null){
            return null;
        }
        
        //如果根节点不在范围内，剪枝
        if(root.val > high){
            return trimBST(root.left, low, high);
        }
        if(root.val < low){
            return trimBST(root.right, low, high);
        }

        //如果正常的话，就正常递归
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;

    }

}
