class Solution {
    
    private class Pair
    {
        int r,c,val;
        
        public Pair(int r, int c, int val)
        {
            this.r=r;
            this.c=c;
            this.val=val;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        
        int n=heightMap.length, m=heightMap[0].length;
        
        boolean[][] bound=new boolean[n][m];
        
        bound[0][0]=true;
        bound[0][m-1]=true;
        bound[n-1][0]=true;
        bound[n-1][m-1]=true;
        
        PriorityQueue<Pair> pq=new PriorityQueue(new Comparator<Pair>(){
            
            public int compare(Pair p1, Pair p2)
            {
                return p1.val-p2.val;
            }
            
        });
        
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=1;i<m-1;i++)
        {
            bound[0][i]=true;
            bound[n-1][i]=true;
            pq.add(new Pair(0,i,heightMap[0][i]));
            pq.add(new Pair(n-1,i,heightMap[n-1][i]));
        }
        
        for(int i=1;i<n-1;i++)
        {
            bound[i][0]=true;
            bound[i][m-1]=true;
            pq.add(new Pair(i,0,heightMap[i][0]));
            pq.add(new Pair(i,m-1,heightMap[i][m-1]));
        }
        
        int ans=0;
        
        while(!pq.isEmpty())
        {
            Pair pair=pq.poll();
            
            for(int[] dir:dirs)
            {
                int x=pair.r+dir[0], y=pair.c+dir[1];
                
                if(x>=0&&x<n&&y>=0&&y<m&&!bound[x][y])
                {
                    if(heightMap[x][y]<pair.val)
                    {
                        ans+=(pair.val-heightMap[x][y]);
                        heightMap[x][y]=pair.val;
                    }
                        
                    pq.add(new Pair(x,y,heightMap[x][y]));
                    bound[x][y]=true;
                }
            }
        }
        
        
        return  ans;
    }
}