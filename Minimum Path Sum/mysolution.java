class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        // N[i][j] shows the minimum sum at position row i and col j
        int[][] N=new int[n][m];
        
        N[0][0]=grid[0][0];
        
        for(int i=1;i<n;i++)
            N[i][0]=N[i-1][0]+grid[i][0];
        
        for(int i=1;i<m;i++)
            N[0][i]=N[0][i-1]+grid[0][i];
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(N[i-1][j]<N[i][j-1])
                    N[i][j]=grid[i][j]+N[i-1][j];
                else
                    N[i][j]=grid[i][j]+N[i][j-1];
            }
        }
        
        return N[n-1][m-1];
    }
}