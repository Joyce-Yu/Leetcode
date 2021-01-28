class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //1.确定dp数组含义
        //dp[i][j] 有i个0和j个1的最大子集
        //2.dp[i][j] = dp[i-zeroNum][j-oneNum]+1;
        // max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
        int[][] dp = new int[m+1][n+1];
        for(String str: strs){
            System.out.println("str");
            int oneNum = 0;
            int zeroNum = 0;
            for(int i = 0; i < str.length();i++){
                if (str.charAt(i) == '1'){
                    oneNum++;
                } else{
                    zeroNum++;
                }
            }
            
            for(int i = m; i >= zeroNum; i--){
                for(int j = n; j >= oneNum; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }

        return dp[m][n];
        
    }
}
