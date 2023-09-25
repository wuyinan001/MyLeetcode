class Solution {
    public int getFood(char[][] grid) {
        
        Queue<int[]> queue=new LinkedList();
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        int n=grid.length, m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        
        boolean found=false;
        for(int i=0;i<n;i++)
        {
            if(found)
                break;
            
            for(int j=0;j<m;j++)
                if(grid[i][j]=='*')
                {
                    queue.add(new int[]{i,j});
                    found=true;
                    break;
                }
        }
            
        
        int ans=0;
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int i=1;i<=size;i++)
            {
                int[] temp=queue.remove();
                
                if(grid[temp[0]][temp[1]]=='#')
                    return ans;
                
                for(int[] dir:dirs)
                {
                    int x=temp[0]+dir[0], y=temp[1]+dir[1];
                    
                    if(x>=0&&x<n&&y>=0&&y<m&&!visited[x][y]&&grid[x][y]!='X')
                    {
                        queue.add(new int[]{x,y});
                        visited[x][y]=true;
                    }
                }
            }
            
            ans++;
        }
        
        return -1;
    }
}