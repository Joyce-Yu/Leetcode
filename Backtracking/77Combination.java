/*
 * https://leetcode-cn.com/problems/combinations/
   By Joyce,参考https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
*/
package com.nice;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution77 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();

    public List<List<Integer>> combine(int n, int k) {
        // 判断base case
        if (k <= 0 || n < k){
            return res;
        }
        dfs(n, k, 1);
        return res;
    }

    public void dfs(int n, int k, int startIndex){
        //回溯终止条件
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        //i <= n 修改为 i <= n - (k - path.size()) + 1，目的是剪枝，删去一些不符合条件的（例如n=7，k=5，startindex=6最后只有一个树了，不可能满足条件）
        //System.out.println("startIndex"+startIndex);
        //System.out.println("i<="+(n - (k - path.size()) + 1));
        for (int i = startIndex; i <= n; i++){
            path.addLast(i);
            //System.out.println("递归之前 => " + path);
            dfs(n, k, i+1);
            path.removeLast();
            //System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        int n = 4, k = 3;
        System.out.println(solution77.combine(n, k));
    }


}
