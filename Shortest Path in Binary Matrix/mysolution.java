class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n=grid.length, m=grid[0].length;
        
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        
        Queue<int[]> queue=new LinkedList();
        
        int ans=1;
        
        if(grid[0][0]==0)
        {
            queue.add(new int[]{0,0});
            grid[0][0]=1;
        }

        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int i=1;i<=size;i++)
            {
                int[] temp=queue.remove();
                
                if(temp[0]==n-1&&temp[1]==m-1)
                    return ans;

                for(int[] dir:dirs)
                {
                    int x=dir[0]+temp[0], y=dir[1]+temp[1];

                    if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==0)
                    {
                        queue.add(new int[]{x,y});
                        grid[x][y]=1;
                    }
                }
                
            }
            
            ans++;
        }
        
        return -1;
    }
}