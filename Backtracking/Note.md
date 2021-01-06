# 回溯法解决的问题
回溯法，一般可以解决如下几种问题：

* 组合问题：N个数里面按一定规则找出k个数的集合
* 排列问题：N个数按一定规则全排列，有几种排列方式
* 切割问题：一个字符串按一定规则有几种切割方式
* 子集问题：一个N个数的集合里有多少符合条件的子集
* 棋盘问题：N皇后，解数独等等

(参考[carl大佬](https://mp.weixin.qq.com/s?__biz=MzUxNjY5NTYxNA==&mid=2247485237&idx=1&sn=1bae4c3d0d3965af44878093a5a49f58&chksm=f9a23464ced5bd72ff9ddcc9c70f69131a9e57e5c1aa674cc62551cd434c64f10a88395dce60&scene=178&cur_album_id=1607983171550167042#rd))

## 组合问题
| 题号        |链接          | 代码  | 说明|
| ------------- |:-------------:| -----:|------------- |
| 77        | [组合（中等）](https://leetcode-cn.com/problems/combinations/)      | [代码](https://github.com/Joyce-Yu/Leetcode/blob/main/Backtracking/77Combination.java) |给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
| 216        |[组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii/)      |[代码](https://github.com/Joyce-Yu/Leetcode/blob/main/Backtracking/216CombinationIII.java) |相比于77，集合固定（1-9），找到和为n的k个数的组合
| 39      | [组合总和（中等)](https://leetcode-cn.com/problems/combination-sum/)   | [代码](https://github.com/Joyce-Yu/Leetcode/blob/main/Backtracking/39Combination.java)|给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
| 40 | [组合总和 II（中等）](https://leetcode-cn.com/problems/combination-sum-ii/)|[代码](https://github.com/Joyce-Yu/Leetcode/blob/main/Backtracking/40CombinationII.java) |相比于39，本题candidates 中的每个数字在每个组合中只能使用一次。数组candidates的元素是有重复的，而39.组合总和是无重复元素的数组candidates
