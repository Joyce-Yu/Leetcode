/*
Leetcode: 226&剑指offer27： https://leetcode-cn.com/problems/invert-binary-tree/ 
by Joyce
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
//递归法 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;

    }
}

//迭代法（层序遍历用Queue）
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;

        Queue<TreeNode> queue = new LinkedList<>(){{add(root);}};

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.right;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

            node.right = node.left;
            node.left = tmp;
            
        }

        return root;

    }
}



