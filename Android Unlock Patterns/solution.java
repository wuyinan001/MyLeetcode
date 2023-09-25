class Solution {
    
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1},{2,1},{2,-1},{-1,2},{1,2},{-2,1},{-2,-1},{-1,-2},{1,-2}};
    
    int[][] crossdir={{0,2},{0,-2},{2,0},{-2,0},{2,2},{-2,-2},{2,-2},{-2,2}};
    
    int ans=0;
    int m,n;
    boolean[][] visited=new boolean[3][3];
    
    private void backTrack(int count, int row, int col)
    {
        if(count>=m)
            ans++;
        
        if(count==n)
            return;
        
        visited[row][col]=true;
        
        for(int[] d:dir)
        {
            int x=row+d[0], y=col+d[1];
            
            if(isValid(x,y))
                backTrack(count+1,x,y);
        }
        
        for(int[] d:crossdir)
        {
            int x=row+d[0], y=col+d[1];
            int x_mid=(row+x)/2, y_mid=(col+y)/2;
            
            if(x_mid>=0&&x_mid<3&&y_mid>=0&&y_mid<3&&visited[x_mid][y_mid]&&isValid(x,y))
                backTrack(count+1,x,y);
        }
        
        visited[row][col]=false;
    }
    
    private boolean isValid(int row, int col)
    {
        return (row>=0&&row<3&&col>=0&&col<3&&!visited[row][col]);
    }
    
    public int numberOfPatterns(int m, int n) {
        
        this.m=m;
        this.n=n;
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                backTrack(1,i,j);
        }
        
        return ans;
    }
}