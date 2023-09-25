class Solution {
    public boolean stoneGame(int[] piles) {
        
        int n=piles.length;
        
        // S[i][j]: Total sum of piles from i to j
        int[][] S=new int[n][n];
        // A[i][j]: Max total sum can get if picking in piles[i] to piles[j]
        int[][] A=new int[n][n];
        
        for(int i=0;i<n;i++)
        {
            S[i][i]=piles[i];
            A[i][i]=piles[i];
        }
        
        for(int s=1;s<=n-1;s++)
        {
            for(int i=0;i<n-s;i++)
            {
                int j=i+s;
                S[i][j]=S[i+1][j]+S[i][j-1]-S[i+1][j-1];
                A[i][j]=Math.max(piles[i]+S[i+1][j]-A[i+1][j],piles[j]+S[i][j-1]-A[i][j-1]);
            }
        }
        
        return A[0][n-1]>S[0][n-1]-A[0][n-1];
    }
}