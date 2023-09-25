class Solution {
    public int orangesRotting(int[][] grid) {
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        Queue<int[]> queue=new LinkedList();
        
        int n=grid.length, m=grid[0].length;
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});
            }
        }
        
        
        while(!queue.isEmpty())
        {
            int N=queue.size();
            
            for(int i=1;i<=N;i++)
            {
                int[] temp=queue.remove();
        
                for(int k=0;k<4;k++)
                {
                    int x=temp[0]+dir[k][0], y=temp[1]+dir[k][1];
                    if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==1)
                    {
                        grid[x][y]=2;
                        queue.add(new int[]{x,y});
                    }
                }
            }
            
            if(!queue.isEmpty())
                ans++;
        }
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1)
                    return -1;
        
        return ans;
    }
}