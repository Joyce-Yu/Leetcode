/*
leetcode: 
  113： https://leetcode-cn.com/problems/path-sum-ii/
  剑指offer：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
by Joyce

关于回溯：
回溯算法就是个多叉树的遍历问题，关键就是在前序遍历和后序遍历的位置做一些操作，算法框架如下:
def backtrack(...):
  for 选择 in 选择列表:
    做选择
    backtrack(...)
    撤销选择
写 backtrack 函数时，需要维护走过的「路径」和当前可以做的「选择列表」，当触发「结束条件」时，将「路径」记入结果集。
（摘自labuladong的算法小抄）

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
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    public void recur(TreeNode root, int target){
        if (root == null){
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            res.add(new LinkedList(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();

    } 


}
