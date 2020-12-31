/*
leetcode:https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
By Joyce
层次遍历用Queue
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        levelOrder(root, res);
        return res;
 
    }

    public void levelOrder(TreeNode root, List<List<Integer>> res){
        if (root == null){
            return;
        }

        //注意Queue的初始化，和Stack不一样
        Queue<TreeNode> queue = new LinkedList<>(){{offer(root);}};
        
        while(!queue.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            //注意i的细节，需要大于0
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }
    }
}
