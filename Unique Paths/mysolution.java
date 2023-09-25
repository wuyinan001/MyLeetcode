class Solution {
    public int uniquePaths(int m, int n) {
        // N[i][j] counts number of paths to get row i and col j
        int[][] N=new int[n][m];
        
        for(int i=0;i<n;i++)
            N[i][0]=1;
        
        for(int i=0;i<m;i++)
            N[0][i]=1;
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                N[i][j]=N[i-1][j]+N[i][j-1];
            }
        }
        
        return N[n-1][m-1];
    }
}