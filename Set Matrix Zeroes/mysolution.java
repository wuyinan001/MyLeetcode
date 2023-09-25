class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n=matrix.length;
        
        if(n==0)
            return;
        
        int m=matrix[0].length;
        
        Queue<int[]> queue=new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                    queue.add(new int[]{i,j});
            }
        }
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty())
        {
            int[] pos=queue.remove();
            
            for(int i=0;i<4;i++)
            {
                int x=pos[0]+dir[i][0], y=pos[1]+dir[i][1];
                
                while(x>=0&&x<n&&y>=0&&y<m)
                {
                    matrix[x][y]=0;
                    x=x+dir[i][0];
                    y=y+dir[i][1];
                }
            }
        }
    }
}