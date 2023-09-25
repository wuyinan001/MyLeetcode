class Solution {
    
    int count=0;
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    int n,m;
    
    public int uniquePathsIII(int[][] grid) {
        
        n=grid.length;
        m=grid[0].length;
        
        int obstacles=0, start_x=0, start_y=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==-1)
                    obstacles++;
                else if(grid[i][j]==1)
                {
                    start_x=i;
                    start_y=j;
                }
            }
        }
        
        backTrack(grid,start_x,start_y,n*m-obstacles);
        
        return count;
    }
    
    private void backTrack(int[][] grid, int row, int col, int remaining)
    {
        if(grid[row][col]==2&&remaining==1)
        {
            count++;
            return;
        }
        
        int temp=grid[row][col];
        
        grid[row][col]=-1;
        remaining--;
        
        for(int[] dir:dirs)
        {
            int x=row+dir[0],y=col+dir[1];
            
            if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]!=-1)
                backTrack(grid,x,y,remaining);
        }
        
        grid[row][col]=temp;
    }
    
}