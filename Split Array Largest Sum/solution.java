class Solution {
    public int splitArray(int[] nums, int m) {
        
        int n=nums.length;
        
        // dp[i][j]: the min largest sum when put i nums (nums[0]...nums[i-1]) in j groups
        // dp[i][0] (i!=0): put nums[0] ... nums[i-1] in no group, which is invalid (infinite)
        // dp[0][j] (j!=0): put no num in j groups, which is invalid (infinite)
        // dp[0][0]: put no num in no group, which is 0. This is starting case for recurrence.
        
        int[][] dp=new int[n+1][m+1];
        
        for(int i=0;i<=n;i++)
            for(int j=0;j<=m;j++)
                dp[i][j]=Integer.MAX_VALUE;
        
        
        dp[0][0]=0;
        
        for(int j=1;j<=m;j++)
        {
            for(int i=1;i<=n;i++)
            {
                int sum=nums[i-1];
                
                dp[i][j]=Math.max(dp[i-1][j-1],sum);
                
                for(int k=i-1;k>0;k--)
                {
                    sum+=nums[k-1];
                    dp[i][j]=Math.min(dp[i][j],Math.max(dp[k-1][j-1],sum));
                }
            }
        }
        
        return dp[n][m];
    }
}