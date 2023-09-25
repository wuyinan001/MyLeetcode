class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        int n=jobDifficulty.length;
        
        if(n<d)
            return -1;
        
        int[][] dp=new int[n][d];
        
        dp[0][0]=jobDifficulty[0];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<d;j++)
                if(j>i)
                    dp[i][j]=Integer.MAX_VALUE;
        
        
        for(int i=1;i<n;i++)
        {
            dp[i][0]=Math.max(dp[i-1][0],jobDifficulty[i]);
        }
        
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<d;j++)
            {
                dp[i][j]=Integer.MAX_VALUE;
                int max=0;
                
                for(int k=i;k>=j;k--)
                {
                    max=Math.max(jobDifficulty[k],max);
                    dp[i][j]=Math.min(dp[k-1][j-1]+max,dp[i][j]);
                }
            }
        }
        
        //print(dp);
            
        return dp[n-1][d-1];    
        
    }
    
    private void print(int[][] dp)
    {
        int n=dp.length, m=dp[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(dp[i][j]+"\t");   
            }
            System.out.println();   
        }
    }
}