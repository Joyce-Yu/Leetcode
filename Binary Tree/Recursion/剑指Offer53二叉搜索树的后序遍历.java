/*
leetcode：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
by Joyce

*/

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0){
            return true;
        }
        return helper(postorder, 0, postorder.length-1);

    }

    public boolean helper(int[] postorder, int l, int r){
        // base case
        if (l >= r) {
            return true;
        }

        // find 第一个比根节点大的index
        int m = l;
        while (postorder[m] < postorder[r]){
            m++;
        }

        //判断后序的数字是否比根节点大
        int p = m;
        while (postorder[p] > postorder[r]){
            p++;
        }

        //需比较序列是否正确，order的左部分和右部分是否满足二叉搜索树的条件。
        return p == r && helper(postorder, l, m-1) && helper(postorder, m, r-1);
    }
}
