class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        if(n==0)
            return 0;
        
        // buy[i]: the max profit from day 0 to day i with the last trans buy
        int[] buy=new int[n];
        // sell[i]: the max profit from day 0 to day i with the last trans sell
        int[] sell=new int[n];
        
        buy[0]=-prices[0];
        sell[0]=0;
        
        for(int i=1;i<n;i++)
        {
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i]=Math.max(buy[i-1],sell[i-1]-prices[i]);
        }
        
        return sell[n-1];
    }
}