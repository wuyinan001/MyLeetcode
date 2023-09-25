class Solution {
    
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    int n,m;
    
    private int backTrack(int[][] matrix, int[][] cache, int row, int col)
    {
        if(cache[row][col]!=0)
            return cache[row][col];
        
        for(int k=0;k<4;k++)
        {
            int x=row+dir[k][0], y=col+dir[k][1];
            if(x>=0&&x<n&&y>=0&&y<m&&matrix[x][y]>matrix[row][col])
            {
                cache[row][col]=Math.max(cache[row][col],backTrack(matrix,cache,x,y));
            }
        }

        return ++cache[row][col];
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        
        n=matrix.length;
        m=matrix[0].length;
        int[][] cache=new int[n][m];
        int ans=0;

        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                ans=Math.max(ans,backTrack(matrix,cache,i,j));
        }
        
        return ans;
    }
}