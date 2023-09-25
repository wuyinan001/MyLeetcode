class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue=new LinkedList<>();
        int n=grid.length, m=grid[0].length;
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        while(!queue.isEmpty())
        {
            //print(grid);
            
            int count=queue.size();
            
            for(int i=1;i<=count;i++)
            {
                int[] coord=queue.remove();
                
                int x=coord[0], y=coord[1];
                
                // Search up
                if(x-1>=0&&grid[x-1][y]==1)
                {
                    grid[x-1][y]=2;
                    queue.add(new int[]{x-1,y});
                }
                    
                
                // Search down
                if(x+1<n&&grid[x+1][y]==1)
                {
                    grid[x+1][y]=2;
                    queue.add(new int[]{x+1,y});
                }
                
                // Search left
                if(y-1>=0&&grid[x][y-1]==1)
                {
                    grid[x][y-1]=2;
                    queue.add(new int[]{x,y-1});
                }
                    
                
                // Search right
                if(y+1<m&&grid[x][y+1]==1)
                {
                    grid[x][y+1]=2;
                    queue.add(new int[]{x,y+1});
                }
            }
            
            if(!queue.isEmpty())
                ans++;
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                    return -1;
            }
        }
        
        return ans;
    }
    
    private void print(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        
        System.out.println("Grid");
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(grid[i][j]+"\t");
            }
            
            System.out.println();
        }
    }
}