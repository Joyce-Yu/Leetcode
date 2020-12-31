/*
leetcode: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
by: Joyce
递归：和前序、中序类似
🌿迭代：参考前序，前序遍历是中左右，后续遍历是左右中，调整一下前序遍历的代码顺序，就变成中右左的遍历顺序，然后再用collection的reverse反转数组

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

//迭代法，参考前序遍历，前序遍历是中左右，后续遍历是左右中，调整一下前序遍历的代码顺序，就变成中右左的遍历顺序，然后再用collection的reverse反转数组，输出的结果顺序就是左右中了
class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorder(root, res);
        return res;
        

    }

    public void postorder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>(){{push(root);}};
        while(!stack.isEmpty()){
            //stack 先压入左再右，pop的时候，中，右，左
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.left != null){
                stack.push(tmp.left);
            }
            if (tmp.right != null){
                stack.push(tmp.right);
            }
        }
        //翻转变成左右中
        Collections.reverse(res); 
    }
    
}


//递归法
class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorder(root, res);
        return res;

    }
    
    public void postorder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);

    }
}





















