class Solution {
    public int[][] generateMatrix(int n) {
       
        int[][] matrix=new int[n][n];
        
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int direction=0;
        int hsteps=n, vsteps=n-1;
        int x=0,y=-1;
        int i=1;
        
        while(i<=n*n)
        {
            if(direction==0||direction==2)
            {
                for(int j=1;j<=hsteps;j++)
                {
                    x=x+dir[direction][0];
                    y=y+dir[direction][1];
                    matrix[x][y]=i++;
                }
                
                hsteps--;
            }
            else
            {
                for(int j=1;j<=vsteps;j++)
                {
                    x=x+dir[direction][0];
                    y=y+dir[direction][1];
                    matrix[x][y]=i++;
                }
                
                vsteps--;
            }
            
            direction=(direction+1)%4;
        }
        
        return matrix;
    }
}