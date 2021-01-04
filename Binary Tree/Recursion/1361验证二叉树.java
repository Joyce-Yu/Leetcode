/*
link: https://leetcode-cn.com/problems/validate-binary-tree-nodes/
by Joyce

*/
class Solution {
    int[] leftChild;
    int[] rightChild;
    boolean[] visited;
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        /***STEP1 计算每个节点的入度***/
        int[] indgreeNode = new int[n];
        for(int i = 0; i < n; i++){
            //若父亲数大于1则为false; 若父亲数等于0的不是1个则为false
            if ((leftChild[i] != -1 && ++indgreeNode[leftChild[i]]>1) || (rightChild[i] != -1 && ++indgreeNode[rightChild[i]]>1)){
                return false;
            }
        }
        //return true;
        int root = -1; 
        
        /***STEP2 找到root（注意：root不一定是第一个节点）***/
        for (int i = 0; i < n; i++){
            if (indgreeNode[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }

        /***STEP3 用dfs遍历树，若存在结点未被访问说明多个连通域***/
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        visited = new boolean[n];
        dfs(root);
        for(boolean v: visited){
            if (!v) return false;
        }
        return true;

    }

    public void dfs(int v){
        if (v == -1) return;
        visited[v] = true;
        dfs(leftChild[v]);
        dfs(rightChild[v]);
    }
}
