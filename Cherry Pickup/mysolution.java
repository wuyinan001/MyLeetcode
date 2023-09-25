class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n=grid.length;
        
        // dp[r1][c1][c2]: max cherries when p1 starts at (r1,c1) and p2 starts at (r2,c2)
        // r2=r1+c1-c2
        int[][][] dp=new int[n][n][n];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    dp[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        
        // If from (r1,c1) or (r2,c2) it is impossible to get to (n-1,n-1), then set dp[r1][c1][c2]=Integer.MIN_VALUE
        if(grid[n-1][n-1]==-1)
            dp[n-1][n-1][n-1]=Integer.MIN_VALUE;
        else
            dp[n-1][n-1][n-1]=grid[n-1][n-1];
        
        // When r1<n-1,c1=n-1,r2<n-1,c2=n-1, both p1 and p2 can only move down
        for(int r1=n-2;r1>=0;r1--)
        {
            if(dp[r1+1][n-1][n-1]<0||grid[r1][n-1]==-1)
                dp[r1][n-1][n-1]=Integer.MIN_VALUE;
            else
                dp[r1][n-1][n-1]=grid[r1][n-1]+dp[r1+1][n-1][n-1];
        }
        
        
        
        // When r1=n-1,c1<n-1,r2=n-1,c2<n-1 both p1 and p2 can only move right
        for(int c1=n-2;c1>=0;c1--)
        {
            if(dp[n-1][c1+1][c1+1]<0||grid[n-1][c1]==-1)
                dp[n-1][c1][c1]=Integer.MIN_VALUE;
            else
                dp[n-1][c1][c1]=grid[n-1][c1]+dp[n-1][c1+1][c1+1];
        }
        
        // When r1<n-1,c1=n-1,r2=n-1,c2<n-1 p1 can only move down, p2 can only move right
        // In this case: r1=c2
        for(int r1=n-2;r1>=0;r1--)
        {
            if(grid[r1][n-1]==-1||grid[n-1][r1]==-1||dp[r1+1][n-1][r1+1]<0)
                dp[r1][n-1][r1]=Integer.MIN_VALUE;
            else
                dp[r1][n-1][r1]=grid[r1][n-1]+grid[n-1][r1]+dp[r1+1][n-1][r1+1];
                
        }
        
        // When r1=n-1,c1<n-1,r2<n-1,c2=n-1 p1 can only move right, p2 can only move down
        // In this case: c1=r2
        for(int c1=n-2;c1>=0;c1--)
        {
            if(grid[n-1][c1]==-1||grid[c1][n-1]==-1||dp[n-1][c1+1][n-1]<0)
                dp[n-1][c1][n-1]=Integer.MIN_VALUE;
            else
                dp[n-1][c1][n-1]=grid[n-1][c1]+grid[c1][n-1]+dp[n-1][c1+1][n-1];
                
        }
        
        // When r1<n-1,c1<n-1,r2<n-1,c2=n-1, p1 can move right or down, p2 can only move down
        for(int r1=n-2;r1>=0;r1--)
        {
            for(int c1=n-2;c1>=0;c1--)
            {
                int r2=r1+c1-(n-1);
                
                if(r2<0||r2>=n-1)
                    continue;
                
                if(grid[r1][c1]==-1||grid[r2][n-1]==-1||(dp[r1+1][c1][n-1]<0&&dp[r1][c1+1][n-1]<0))
                    dp[r1][c1][n-1]=Integer.MIN_VALUE;
                else
                {
                    dp[r1][c1][n-1]=grid[r1][c1]+grid[r2][n-1];
                    dp[r1][c1][n-1]+=Math.max(dp[r1+1][c1][n-1],dp[r1][c1+1][n-1]);
                }
                
            }
        }
        
        // When r1<n-1,c1<n-1,r2=n-1,c2<n-1 p1 can move right or down, p2 can only move right
        for(int r1=n-2;r1>=0;r1--)
        {
            for(int c1=n-2;c1>=0;c1--)
            {
                int c2=r1+c1-(n-1);
                
                if(c2<0||c2>=n-1)
                    continue;
                
                if(grid[r1][c1]==-1||grid[n-1][c2]==-1||(dp[r1+1][c1][c2+1]<0&&dp[r1][c1+1][c2+1]<0))
                    dp[r1][c1][c2]=Integer.MIN_VALUE;
                else
                {
                    dp[r1][c1][c2]=grid[r1][c1]+grid[n-1][c2];
                    dp[r1][c1][c2]+=Math.max(dp[r1+1][c1][c2+1],dp[r1][c1+1][c2+1]);
                }
                
            }
        }
        
        // When r1<n-1,c1=n-1,r2<n-1,c2<n-1, p1 can only move down, p2 can move right or down
        for(int r1=n-2;r1>=0;r1--)
        {
            for(int c2=n-2;c2>=0;c2--)
            {
                int r2=r1+(n-1)-c2;
                
                if(r2<0||r2>=n-1)
                    continue;
                
                //System.out.println("r1,r2,c2 "+r1+" "+r2+" "+c2);
                
                if(grid[r1][n-1]==-1||grid[r2][c2]==-1||(dp[r1+1][n-1][c2]<0&&dp[r1+1][n-1][c2+1]<0))
                    dp[r1][n-1][c2]=Integer.MIN_VALUE;
                else
                {
                    dp[r1][n-1][c2]=grid[r1][n-1]+grid[r2][c2];
                    dp[r1][n-1][c2]+=Math.max(dp[r1+1][n-1][c2],dp[r1+1][n-1][c2+1]);
                }
                
            }
        }
        
        // When r1=n-1,c1<n-1,r2<n-1,c2<n-1 p1 can only move right, p2 can move right or down
        for(int c1=n-2;c1>=0;c1--)
        {
            for(int c2=n-2;c2>=0;c2--)
            {
                int r2=n-1+c1-c2;
                
                if(r2<0||r2>=n-1)
                    continue;
                
                if(grid[n-1][c1]==-1||grid[r2][c2]==-1||(dp[n-1][c1+1][c2]<0&&dp[n-1][c1+1][c2+1]<0))
                    dp[n-1][c1][c2]=Integer.MIN_VALUE;
                else
                {
                    dp[n-1][c1][c2]=grid[n-1][c1]+grid[r2][c2];
                    dp[n-1][c1][c2]+=Math.max(dp[n-1][c1+1][c2],dp[n-1][c1+1][c2+1]);
                }
                
            }
        }
        
        
        
        // When r1<n-1,r2<n-1,c1<n-1,c2<n-1, p1 can move right or down, p2 can move right or down
        for(int r1=n-2;r1>=0;r1--)
        {
            for(int c1=n-2;c1>=0;c1--)
            {
                for(int c2=n-2;c2>=0;c2--)
                {
                    int r2=r1+c1-c2;
                    
                    if(r2<0||r2>=n-1)
                        continue;
                    
                    if(grid[r1][c1]==-1||grid[r2][c2]==-1||(dp[r1+1][c1][c2]<0&&dp[r1][c1+1][c2]<0&&dp[r1+1][c1][c2+1]<0&&dp[r1][c1+1][c2+1]<0))
                        dp[r1][c1][c2]=Integer.MIN_VALUE;
                    else
                    {
                        if(r1==r2&&c1==c2)
                            dp[r1][c1][c2]=grid[r1][c1];
                        else
                            dp[r1][c1][c2]=grid[r1][c1]+grid[r2][c2];
                        
                        dp[r1][c1][c2]+=Math.max(Math.max(dp[r1+1][c1][c2],dp[r1][c1+1][c2]),Math.max(dp[r1+1][c1][c2+1],dp[r1][c1+1][c2+1]));
                    }
                }
            }
        }
        
        
        return Math.max(0,dp[0][0][0]);
    }
}