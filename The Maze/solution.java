class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int n=maze.length;
        
        if(n==0)
            return false;
        
        int m=maze[0].length;
        
        // mark[i][j]=1 if ball stops at (i,j)
        boolean[][] mark=new boolean[n][m];
        
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<int[]> queue=new LinkedList<>();
        
        queue.add(start);
        mark[start[0]][start[1]]=true;
        
        while(!queue.isEmpty())
        {
            int[] pos=queue.remove();
            
            if(pos[0]==destination[0]&&pos[1]==destination[1])
                return true;
            
            for(int[] dir:dirs)
            {
                int x=pos[0],y=pos[1];
                
                while(x>=0&&y>=0&&x<=n-1&&y<=m-1&&maze[x][y]==0)
                {
                    x+=dir[0];
                    y+=dir[1];
                }
                
                //System.out.println("x: "+x+" y "+y);
                //System.out.println("dir[0] "+dir[0]+" dir[1] "+dir[1]);
                
                if(!mark[x-dir[0]][y-dir[1]])
                {
                    mark[x-dir[0]][y-dir[1]]=true;
                    queue.add(new int[]{x-dir[0],y-dir[1]});
                    
                }
            }
        }
        
        return false;
    }
    
    
    private void print(int[][] a)
    {
        int n=a.length;
        int m=a[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(a[i][j]+"\t");
            }
            
            System.out.println();
        }
    }
}