package com.nice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Chenbing
 * @date: 2021.01.18 13:25
 * @description:
 */
public class leetcode_0103_ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftPrint = true;

        while(!queue.isEmpty()){
            List<Integer> path = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size;i++){
                TreeNode cur = queue.poll();

                if(leftPrint){
                    path.add(cur.val);
                } else{
                    path.add(0, cur.val);
                }

                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            leftPrint = !leftPrint;
            res.add(path);

        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode x2 = new TreeNode(2);
        TreeNode x3 = new TreeNode(3);
        TreeNode x4 = new TreeNode(4);
        TreeNode x5 = new TreeNode(5);
        root.left = x2;
        root.right = x3;
        x2.left = x4;
        x2.right = null;
        x3.left = null;
        x3.right = x5;

        leetcode_0103_ZigzagLevelOrderTraversal leetcode_0103_zigzagLevelOrderTraversal = new leetcode_0103_ZigzagLevelOrderTraversal();
        System.out.println(leetcode_0103_zigzagLevelOrderTraversal.zigzagLevelOrder(root));

    }
}
