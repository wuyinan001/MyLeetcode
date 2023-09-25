class Solution {
    
    private static final int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    public int maximumMinimumPath(int[][] A) {
        
        int n=A.length, m=A[0].length;
        
        int[][] L=new int[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                L[i][j]=-1;
        
        L[0][0]=A[0][0];
		
        PriorityQueue<int[]> pq=new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a1, int[] a2)
            {
                return a2[2]-a1[2];
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
            
            for(int k=0;k<4;k++)
            {
                int x=temp[0]+dir[k][0], y=temp[1]+dir[k][1];
               
                if(x>=0&&x<n&&y>=0&&y<m&&Math.min(temp[2],A[x][y])>L[x][y])
                {
                    L[x][y]=Math.min(temp[2],A[x][y]);
                    pq.add(new int[]{x,y,Math.min(temp[2],A[x][y])});
                }
            }
        }
        
        return -1;
    }
}