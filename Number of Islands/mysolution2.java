class Solution {
    public int numIslands(char[][] grid) {
        
        int n=grid.length;
        
        if(n==0)
            return 0;
        
        int m=grid[0].length;
        
        int ans=0;
        int[][] move={{1,0},{-1,0},{0,1},{0,-1}};
        
        Queue<int[]> queue=new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    queue.add(new int[]{i,j});
                    grid[i][j]='0';
                    ans++;
                    
                    while(!queue.isEmpty())
                    {
                        int[] pos=queue.remove();

                        for(int k=0;k<4;k++)
                        {
                            int x=pos[0]+move[k][0],y=pos[1]+move[k][1];

                            if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]=='1')
                            {
                                queue.add(new int[]{x,y});
                                grid[x][y]='0';
                            }
                        }
                    }
                }
            }
        }
        
        return ans;
        
    }
}