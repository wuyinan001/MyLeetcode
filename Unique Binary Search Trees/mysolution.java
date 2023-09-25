class Solution {
    public int numTrees(int n) {
        if(n==0)
            return 0;
        
        // L[i][j] shows num of trees with i nodes and j nodes under the left branch
        int[][] L=new int[n+1][n+1];
        // S[i][j] show sum of L[i][0] to L[i][j]
        int[][] S=new int[n+1][n+1];
        
        for(int i=1;i<=n;i++)
        {
            L[i][0]=1;
            S[i][0]=1;
        }
        
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=i-2;j++)
            {
                L[i][j]=S[i-1][j];
                S[i][j]=S[i][j-1]+L[i][j];
            }
            
            L[i][i-1]=L[i][i-2];
            S[i][i-1]=S[i][i-2]+L[i][i-1];
        }
        
        return S[n][n-1];
    }
}