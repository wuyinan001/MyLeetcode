class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int n=grid.length, m=grid[0].length;
        
        int[] top=new int[m];
        int[] left=new int[n];
        
        for(int i=0;i<n;i++)
        {
            left[i]=grid[i][0];
            
            for(int j=1;j<m;j++)
                left[i]=Math.max(grid[i][j],left[i]);
        }
        
        for(int j=0;j<m;j++)
        {
            top[j]=grid[0][j];
            
            for(int i=1;i<n;i++)
                top[j]=Math.max(grid[i][j],top[j]);
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ans+=Math.min(top[j]-grid[i][j],left[i]-grid[i][j]);
            }
        }
        
        return ans;
    }
}