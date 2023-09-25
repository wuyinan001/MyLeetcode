class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int n=grid.length, m=grid[0].length;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        
        Queue<int[]> queue=new LinkedList();
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int curr=1;
                    queue.add(new int[]{i,j});
                    grid[i][j]=0;
                    
                    while(!queue.isEmpty())
                    {
                        int[] temp=queue.remove();
                        
                        for(int[] dir:dirs)
                        {
                            int x=temp[0]+dir[0], y=temp[1]+dir[1];
                            
                            if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==1)
                            {
                                curr++;
                                queue.add(new int[]{x,y});
                                grid[x][y]=0;
                            }
                        }
                    }
                    
                    ans=Math.max(ans,curr);
                }
            }
        }
        
        return ans;
    }
}