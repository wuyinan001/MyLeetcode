class Solution {
    public int swimInWater(int[][] grid) {
        
        int n=grid.length, m=grid[0].length;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        int[][] L=new int[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                L[i][j]=Integer.MAX_VALUE;
        
        L[0][0]=grid[0][0];
        
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return a1[2]-a2[2];
            }
            
        });
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                pq.add(new int[]{i,j,L[i][j]});
        
        while(!pq.isEmpty())
        {
            int[] temp=pq.poll();
            
            if(temp[0]==n-1&&temp[1]==m-1)
                return temp[2];
            
            for(int[] dir:dirs)
            {
                int x=temp[0]+dir[0], y=temp[1]+dir[1];
                
                if(x>=0&&x<n&&y>=0&&y<m&&L[x][y]>Math.max(temp[2],grid[x][y]))
                {
                    L[x][y]=Math.max(temp[2],grid[x][y]);
                    pq.add(new int[]{x,y,L[x][y]});
                }
            }
        }
        
        return -1;
    }
}