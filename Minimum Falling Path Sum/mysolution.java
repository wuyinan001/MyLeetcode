class Solution {
    
    int n,m;
    
    public int minFallingPathSum(int[][] matrix) {
        
        n=matrix.length;
        m=matrix[0].length;
        
        // memo[i][j]:min sum ending at memo[i][j]
        int[][] memo=new int[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                memo[i][j]=Integer.MIN_VALUE;
        
        int min=Integer.MAX_VALUE;
        
        for(int j=0;j<m;j++)
            min=Math.min(min,dp(matrix,memo,n-1,j));
        
        return min;
    }
    
    private int dp(int[][] matrix, int[][] memo, int row, int col)
    {
        if(row==0)
        {
            memo[row][col]=matrix[row][col];
            return memo[row][col];
        }
        
        if(memo[row][col]>Integer.MIN_VALUE)
            return memo[row][col];
        
        if(col==0&&col==m-1)
        {
            memo[row][col]=matrix[row][col]+dp(matrix,memo,row-1,col);
        }
        else if(col==0)
        {
            memo[row][col]=matrix[row][col]+Math.min(dp(matrix,memo,row-1,col),dp(matrix,memo,row-1,col+1));
        }
        else if(col==m-1)
        {
            memo[row][col]=matrix[row][col]+Math.min(dp(matrix,memo,row-1,col-1),dp(matrix,memo,row-1,col));
        }
        else
            memo[row][col]=matrix[row][col]+Math.min(dp(matrix,memo,row-1,col-1),Math.min(dp(matrix,memo,row-1,col),dp(matrix,memo,row-1,col+1)));
        
        
        return memo[row][col];
    }
}