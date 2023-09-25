class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int n=prices.length;
        
        if(n==0||k==0)
            return 0;
        
        // sell[i][j]: max profit from day 0 to day i with j+1 transactions when last transaction is sell
        // buy[i][j]: max profit from day 0 to day i with j+1 transactions when last transaction is buy
        int[][] sell=new int[n][k];
        int[][] buy=new int[n][k];
        
        // Set all invalid cases to be -9999, not set Integer.MIN_VALUE because it may overflow after minus an integer
        for(int i=0;i<n;i++)
            for(int j=0;j<k;j++)
            {
                sell[i][j]=-9999;
                buy[i][j]=-9999;
            }
        
        buy[0][0]=-prices[0];
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<k;j++)
            {
                if(j==0)
                    buy[i][j]=Math.max(buy[i-1][j],-prices[i]);
                else
                    buy[i][j]=Math.max(sell[i-1][j-1]-prices[i],buy[i-1][j]);
                
                sell[i][j]=Math.max(buy[i-1][j]+prices[i],sell[i-1][j]);
            }
        }
        
        int ans=0;
        
        for(int j=0;j<k;j++)
            ans=Math.max(ans,sell[n-1][j]);
        
        return ans;
    }
}