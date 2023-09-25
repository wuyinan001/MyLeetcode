class Solution {
    
    public int maxProfit(int k, int[] prices) {
        
        int n=prices.length;
        
        // If there is only one day price or no transaction, then no profit. Because cannot sell on first day. 
        if(n<=1||k==0)
            return 0;
        
        int[][] S=new int[n][k+1];
        int[][] B=new int[n][k+1];
        
        S[0][1]=0;
        B[0][1]=-prices[0];
        
        // S[0][j]=0 because cannot sell on day 0; B[0][j]=-prices[0] because if buy on day 0 the profit will be -prices[0]
        for(int j=1;j<=k;j++)
        {
            S[0][j]=0;
            B[0][j]=-prices[0];

        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=k;j++)
            {
                S[i][j]=Math.max(S[i-1][j],B[i-1][j]+prices[i]);
                B[i][j]=Math.max(B[i-1][j],S[i-1][j-1]-prices[i]);
            }

        }
        
        return S[n-1][k];
    }
}