class Solution {
    
    private class Position
    {
        int row,col,distance;
        String path;
        
        public Position(int r, int c, int d, String p)
        {
            row=r;
            col=c;
            distance=d;
            path=p;
        }
    }
    
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        
        int n=maze.length, m=maze[0].length;
        
        PriorityQueue<Position> pq=new PriorityQueue(new Comparator<Position>(){
            
            public int compare(Position p1, Position p2)
            {
                if(p1.distance==p2.distance)
                    return p1.path.compareTo(p2.path);
                
                return p1.distance-p2.distance;
            }
            
        });
        
        // 0: up; 1: left; 2: down; 3: right
        int[][] dirs={{-1,0},{0,-1},{1,0},{0,1}};
        
        Map<Integer,String> map=new HashMap();
        
        map.put(0,"u");
        map.put(1,"l");
        map.put(2,"d");
        map.put(3,"r");
        
        boolean[][] visited=new boolean[n][m];
        
        pq.add(new Position(ball[0],ball[1],0,""));
        
        while(!pq.isEmpty())
        {
            Position p=pq.poll();
            
            if(!visited[p.row][p.col])
            {
                visited[p.row][p.col]=true;
                
                if(p.row==hole[0]&&p.col==hole[1])
                    return p.path;
                
                for(int i=0;i<4;i++)
                {
                    int x=p.row, y=p.col;
                    int steps=0;
                    
                    while(x>=0&&x<n&&y>=0&&y<m&&maze[x][y]==0&&!(x==hole[0]&&y==hole[1]))
                    {
                        x=x+dirs[i][0];
                        y=y+dirs[i][1];
                        steps++;
                    }
                    
                    if(x==hole[0]&&y==hole[1])
                    {
                        pq.add(new Position(x,y,steps+p.distance,p.path+map.get(i)));
                    }
                    else
                    {
                        x=x-dirs[i][0];
                        y=y-dirs[i][1];
                        steps--;
                        pq.add(new Position(x,y,steps+p.distance,p.path+map.get(i)));
                    }
                }
            }
            
        }
        
        return "impossible";
    }
}