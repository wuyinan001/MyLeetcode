class Solution {
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        int n=maze.length, m=maze[0].length;
        Queue<int[]> queue=new LinkedList();
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        
        // distance[i][j]: min distance from start position to position i,j
        int[][] distance=new int[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                distance[i][j]=Integer.MAX_VALUE;
        
        distance[start[0]][start[1]]=0;
        
        queue.add(start);
        
        while(!queue.isEmpty())
        {
            int[] temp=queue.remove();
            
            for(int[] dir:dirs)
            {
                int x=temp[0]+dir[0], y=temp[1]+dir[1];
                int steps=1;
                
                while(x>=0&&x<n&&y>=0&&y<m&&maze[x][y]==0)
                {
                    x=x+dir[0];
                    y=y+dir[1];
                    steps++;
                }
                
                x=x-dir[0];
                y=y-dir[1];
                steps--;
                
                if(distance[x][y]>distance[temp[0]][temp[1]]+steps)
                {
                    queue.add(new int[]{x,y});
                    distance[x][y]=distance[temp[0]][temp[1]]+steps;
                }
            }
        }
        
        return distance[destination[0]][destination[1]]==Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}