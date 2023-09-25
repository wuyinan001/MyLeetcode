class Solution {
    
    int n,m;
    
    int[][][] memo; 
    
    public int cherryPickup(int[][] grid) {
        
        n=grid.length;
        m=grid[0].length;
        memo=new int[n][m][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<m;k++)
                {
                    memo[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        
        return dp(grid,0,0,m-1);
    }
    
    private int dp(int[][] grid, int r1, int c1, int c2)
    {
        if(r1==n||c1==m||c2==m||c1==-1||c2==-1)
            return Integer.MIN_VALUE;
        else if(r1==n-1)
        {
            if(c1!=c2)
                memo[r1][c1][c2]=grid[r1][c1]+grid[r1][c2];
            else
                memo[r1][c1][c2]=grid[r1][c1];
            
            return memo[r1][c1][c2];
        }
        else if(memo[r1][c1][c2]!=Integer.MIN_VALUE)
            return  memo[r1][c1][c2];
        else
        {
            int ans=grid[r1][c1];
            
            if(c1!=c2)
                ans+=grid[r1][c2];
            
            int max=0;
            
            for(int i=-1;i<=1;i++)
                for(int j=-1;j<=1;j++)
                {
                    max=Math.max(max,dp(grid,r1+1,c1+i,c2+j));
                }
            
            ans+=max;
            
            memo[r1][c1][c2]=ans;
            return ans;
        }
        
    }
}