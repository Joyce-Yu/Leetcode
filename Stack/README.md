# :green_book: 剑指offer
[合集](https://leetcode-cn.com/problemset/lcof/?topicSlugs=stack)
- [x] [剑指 Offer 09	用两个栈实现队列  	943	72.6%	简单](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)	

用LinkedList初始化两个栈 A，B；A负责队列的“进”， B负责队列的出。如果要出了且B中无元素，就把A中的压入B
- [x] [剑指 Offer 30	包含min函数的栈  	449	57.4%	简单](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

用Deque初始化两个栈 A，B。其中A负责add，top，pop等操作。B存放当前最小的值。add时如果B是空，或者B当前的peek() 大于要push的值，则把该值push入B。当pop时，A如果pop的值等于B的peek（），b也得pop。返回最min值，直接返回B的peek();
- [x] [剑指 Offer 59 - II	队列的最大值  	814	47.4%	中等](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/submissions/)

初始化一个queue和一个双端队列deque。push操作时，需要将较小值压入deque，保证队列前面一直是最大值，如果压入的数据大于deque的末尾，则将末尾的数据依次弹出，再压入较大数据。弹出时要注意deque的peekFirst如果等于queue的poll，也需要弹出。最后注意空栈时候的情况，记得判断是否为空。

# :orange_book: leetcode
[合集](https://leetcode-cn.com/problemset/all/?topicSlugs=stack&listId=2ckc81c)

## TO DO
- [ ] [341	扁平化嵌套列表迭代器  	139	65.8%	中等](https://leetcode-cn.com/problems/flatten-nested-list-iterator)
题目不太理解
- [ ] [85	最大矩形  	459	51.6%	困难](https://leetcode-cn.com/problems/maximal-rectangle/)
- [ ] [394	字符串解码  	875	53.8%	中等](https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/)
## Done
- [x] [20	有效的括号  	3697	43.6%	简单](https://leetcode-cn.com/problems/valid-parentheses/submissions/)	
需要用一个map来存储匹配关系，再用deque依次放入character，如果要放入的为},])，则deque的peekLast需要与之匹配。

- [x] [42	接雨水  	1590	53.9%	困难](https://leetcode-cn.com/problems/trapping-rain-water/)	
动态规划法 找出当前指针前面的最大height和指针后面的最大height
- [ ] 84	柱状图中最大的矩形  	778	42.5%	困难	
- [x] [94	二叉树的中序遍历  	1337	74.6%	中等](https://leetcode-cn.com/problems/binary-tree-inorder-traversal)	
- [x] [103	二叉树的锯齿形层序遍历  	1100	57.0%	中等](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/submissions/)
二叉树的层次遍历，需要注意增加一个是否从左打印的flag，如果否的化，path.add(0, value) 在list的首位增加value

- [x] [150	逆波兰表达式求值  	439	50.9%	中等](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation)
用到switch，case，default语句 以及栈
- [x] [155	最小栈  	1090	56.0%	简单](https://leetcode-cn.com/problems/min-stack/)	
- [x] [227	基本计算器 II  	233	38.6%	中等](https://leetcode-cn.com/problems/basic-calculator-ii/)
[参考](https://leetcode-cn.com/problems/basic-calculator-ii/solution/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/)
每次指向的运算符，并非直接进行运算，而是将之前记录的操作符代入计算。（最开始默认sign为+）


