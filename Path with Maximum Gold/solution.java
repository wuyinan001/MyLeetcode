class Solution {
    
    // Find the maximum gold starting at row and col
    private int findMaximum(int[][] grid, int row, int col, boolean[][] visited)
    {
        int n=grid.length, m=grid[0].length;
        if(row<0||row>=n||col<0||col>=m)
            return 0;
        
        if(grid[row][col]==0||visited[row][col])
            return 0;
        
        int ans=grid[row][col];
        
        visited[row][col]=true;
        
        int u=findMaximum(grid,row-1,col,visited);
        int d=findMaximum(grid,row+1,col,visited);
        int l=findMaximum(grid,row,col-1,visited);
        int r=findMaximum(grid,row,col+1,visited);
        
        visited[row][col]=false;
        
        return ans+Math.max(Math.max(u,d),Math.max(l,r));
    }
    
    public int getMaximumGold(int[][] grid) {
        
        int n=grid.length, m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                ans=Math.max(ans,findMaximum(grid,i,j,visited));
        }
        
        return  ans;
    }
}