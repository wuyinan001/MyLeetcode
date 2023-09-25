class Solution {
    public int numWays(int steps, int arrLen) {
        
        // dp[i][j]: num ways to moving i steps to index 0 from index j
        
        int[][] memo=new int[steps+1][arrLen];
        
        for(int i=0;i<=steps;i++)
            for(int j=0;j<arrLen;j++)
                memo[i][j]=-1;
        
        for(int j=1;j<arrLen;j++)
            memo[0][j]=0;
        
        memo[0][0]=1;
        
        return dp(steps,0,memo);
        
    }
    
    private int dp(int i, int j, int[][] memo)
    {
        if(j<0||j>=memo[0].length)
            return 0;
        
        if(memo[i][j]!=-1)
            return memo[i][j];
        
        int ans=0;
        
        ans=(ans+dp(i-1,j-1,memo))%(int)(1e9+7);
        ans=(ans+dp(i-1,j,memo))%(int)(1e9+7);
        ans=(ans+dp(i-1,j+1,memo))%(int)(1e9+7);
        
        
        memo[i][j]=ans;
        
        return ans;
            
    }
    
}