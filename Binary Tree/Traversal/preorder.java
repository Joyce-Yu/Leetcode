/*
Note:
leetcode link：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
by：Joyce-Bing
两种解法： 迭代和递归
迭代：创建一个stack来存放节点，由于是前序遍历，先push右节点，再push左节点（栈先进后出）；(ps：层序遍历的话，用queue）
递归：创建一个辅助函数，访问根结点。如果根节点为null，返回；不为null，加入其val，再遍历其左右子树
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
//迭代法
class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return new LinkedList<>();
        }
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>(){{push(root);}};
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right!=null){
                stack.push(tmp.right);
            }
            if (tmp.left!=null){
                stack.push(tmp.left);
            }
        }
        return res;

    }
}

//递归法
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorder(root, res);
        return res;
        
    }

    public void preorder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);

    }
}

