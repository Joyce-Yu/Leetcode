/*
leetcode:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
by Joyce
根据二叉搜索树的中序遍历倒序为递减序列。
因此，求 “二叉搜索树第 kk 大的节点” 可转化为求 “此树的中序遍历倒序的第 kk 个节点”。

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
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){ 
        if (root == null){
            return;
        }
        dfs(root.right);
        if (k == 0){
            return;
        }
        if (--k == 0){
            res = root.val;
        }
        dfs(root.left);
    }
}
