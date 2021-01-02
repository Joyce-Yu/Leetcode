/*
leetcode: https://leetcode-cn.com/problems/count-complete-tree-nodes/
by Joyce
完全二叉树的做法可以结合普通二叉树和满二叉树的做法。
  普通二叉树，return 1 + countNodes(root.left) + countNodes(root.right);
  满二叉树：计算出树的高度，直接2的h次-1
  完全二叉树：如果左右高度不同，则用普通二叉树；反之，满二叉树

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
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }

        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null){
            l = l.left;
            hl++;
        }
        while (r != null){
            r = r.right;
            hr++;
        }

        if (hl == hr){
            return (int)Math.pow(2, hl)-1;
        }else{
            return 1 + countNodes(root.left)+ countNodes(root.right);
        }



    }
}
