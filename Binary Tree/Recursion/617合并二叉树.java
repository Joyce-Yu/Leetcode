/*
leetcode:https://leetcode-cn.com/problems/merge-two-binary-trees/
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
//way1 迭代 2ms;38.7MB
//way2 递归 1ms; 38.4MB
// class Solution {
//     public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//         if (t1==null) return t2;
//         if (t2==null) return t1;

//         TreeNode newTree = new TreeNode(t1.val+t2.val);
//         Queue<TreeNode> queue = new LinkedList<>();
//         Queue<TreeNode> queue1 = new LinkedList<>();
//         Queue<TreeNode> queue2 = new LinkedList<>();
//         queue.add(newTree);
//         queue1.add(t1);
//         queue2.add(t2);
        
//         while(!queue1.isEmpty() || !queue2.isEmpty()){
//             TreeNode node = queue.poll();
//             TreeNode node1 = queue1.poll();
//             TreeNode node2 = queue2.poll();
//            // newTree.val = node1.val+node2.val;

//             if(node1.left!=null || node2.left!=null){
//                 if(node1.left!=null && node2.left!=null){
//                     TreeNode tmp = new TreeNode(node1.left.val+node2.left.val);
//                     node.left = tmp;
//                     queue.add(tmp);
//                     queue1.add(node1.left);
//                     queue2.add(node2.left);
//                 }else if(node1.left==null){
//                     node.left = node2.left;
//                 }else{
//                     node.left = node1.left;
//                 }
//             }

//             if(node1.right!=null || node2.right!=null){
//                 if(node1.right!=null && node2.right!=null){
//                     TreeNode tmp = new TreeNode(node1.right.val+node2.right.val);
//                     node.right = tmp;
//                     queue.add(tmp);
//                     queue1.add(node1.right);
//                     queue2.add(node2.right);
//                 }else if(node1.right==null){
//                     node.right = node2.right;
//                 }else{
//                     node.right = node1.right;
//                 }
//             }

//         }
//         return newTree;

//     }
// }
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null) return t2;
        if (t2==null) return t1;

        TreeNode newTree = new TreeNode(t1.val+t2.val);
        newTree.left = mergeTrees(t1.left, t2.left);
        newTree.right = mergeTrees(t1.right, t2.right);
        return newTree;

    }
}
