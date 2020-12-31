/*
leetcode link:https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
by Joyce
两种方法：递归和迭代
1. 递归和前序的差不多；
2. 🌟迭代需要注意： 因为前序遍历的顺序是中左右，先访问的元素是中间节点，要处理的元素也是中间节点，访问的元素和处理的元素顺序是一致的，都是中间节点。
而中序遍历处理顺序和访问顺序是不一致的：而中序遍历是左中右，先访问的是二叉树顶部的节点，然后一层一层向下访问，直到到达树左面的最底部，再开始处理节点
那么在使用迭代法写中序遍历，就需要借用指针的遍历来帮助访问节点，栈则用来处理节点上的元素。（from leetcode解析）
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

//迭代法，需要注意刚开始不能把root push进去，要找到最左的节点，然后pop，再add到result，然后看右侧是否有节点
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null){
            //需找到最左侧的节点
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
    }
}

//递归，和前序差不多
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    
    }

    public void inorder(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        
        //此处和前序有差异
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);   

    }
}

