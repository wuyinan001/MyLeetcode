class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        int n=maze.length, m=maze[0].length;
        
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        
        int[][] distance=new int[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                distance[i][j]=Integer.MAX_VALUE;
        
        distance[start[0]][start[1]]=0;
        
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return distance[a1[0]][a1[1]]-distance[a2[0]][a2[1]];
            }
            
        });
        
        
        pq.add(new int[]{start[0],start[1]});
        
        while(!pq.isEmpty())
        {
            int[] temp=pq.poll();
            
            if(temp[0]==destination[0]&&temp[1]==destination[1])
                return distance[temp[0]][temp[1]];
            
            for(int[] dir:dirs)
            {
                int x=temp[0], y=temp[1], step=0;
                
                while(x>=0&&x<n&&y>=0&&y<m&&maze[x][y]==0)
                {
                    x+=dir[0];
                    y+=dir[1];
                    step++;
                }
                
                x-=dir[0];
                y-=dir[1];
                step--;
                
                if(distance[x][y]>distance[temp[0]][temp[1]]+step)
                {
                    
                    distance[x][y]=distance[temp[0]][temp[1]]+step;
                    pq.add(new int[]{x,y});
                }
            }
        }
        
        return -1;
    }
}