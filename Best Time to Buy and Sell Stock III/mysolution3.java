class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        
        if(n<=1)
            return 0;
        
        int[][] S=new int[n][3];
        int[][] B=new int[n][3];
        
        for(int j=1;j<=2;j++)
        {
            S[0][j]=0;
            B[0][j]=-prices[0];
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=2;j++)
            {
                S[i][j]=Math.max(S[i-1][j],B[i-1][j]+prices[i]);
                B[i][j]=Math.max(B[i-1][j],S[i-1][j-1]-prices[i]);
            }
        }
        
        return S[n-1][2];
    }
}