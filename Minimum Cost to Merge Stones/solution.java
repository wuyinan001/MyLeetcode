class Solution {
    public int mergeStones(int[] stones, int k) {
        
        int n=stones.length;
        
        if((n-1)%(k-1)!=0)
            return -1;
        
        int[] presum=new int[n+1];
        
        for(int i=1;i<=n;i++)
            presum[i]=presum[i-1]+stones[i-1];
        
        int[][] dp=new int[n][n];
        
        for(int gap=k-1;gap<=n-1;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;
                for(int m=i;m<j;m+=k-1)
                {
                    dp[i][j]=Math.min(dp[i][j],dp[i][m]+dp[m+1][j]);
                }
                
                if((j-i)%(k-1)==0)
                    dp[i][j]+=presum[j+1]-presum[i];
            }
        }
        
        return dp[0][n-1];
    }
}