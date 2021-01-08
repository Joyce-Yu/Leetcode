package com.nice;

/**
 * https://leetcode-cn.com/problems/word-search/
 *
 */
class Solution79 {
    private boolean[][] marked;
    private int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};
    private int m, n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0){
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean backtracking(int i, int j, int start){
        if (start == word.length()-1){
            return board[i][j]==word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)){
            marked[i][j] = true;
            for(int k = 0; k < 4; k++){
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]){
                    if (backtracking(newX, newY, start+1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        //char[][] board = {{'a', 'b'}};
        //String word = "ba";
        Solution79 solution79 = new Solution79();

        System.out.println(solution79.exist(board, "SEE"));
    }
}
