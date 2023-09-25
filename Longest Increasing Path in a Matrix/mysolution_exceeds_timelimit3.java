class Solution {
    
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    private int backTrack(int[][] matrix, int row, int col)
    {
        int n=matrix.length, m=matrix[0].length;
    
        int max=0;
        
        for(int k=0;k<4;k++)
        {
            int x=row+dir[k][0], y=col+dir[k][1];
            if(x>=0&&x<n&&y>=0&&y<m&&matrix[x][y]>matrix[row][col])
            {
                max=Math.max(max,backTrack(matrix,x,y));
            }
        }

        return 1+max;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int n=matrix.length, m=matrix[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                ans=Math.max(ans,backTrack(matrix,i,j));
        }
        
        return ans;
    }
}