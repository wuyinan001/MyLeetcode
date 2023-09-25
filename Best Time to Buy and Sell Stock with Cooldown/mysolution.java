class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        
        if(n==0||n==1)
            return 0;
        
        // buy[i]: max profit until day i with last transaction buy(last transaction doesn't have to be on day i)
        int[] buy=new int[n];
        // sell[i]: max profit until day i with last transaction sell(last transaction doesn't have to be on day i)
        int[] sell=new int[n];
        
        buy[0]=-prices[0];
        sell[0]=0;
        
        buy[1]=Math.max(buy[0],-prices[1]);
        sell[1]=Math.max(sell[0],buy[0]+prices[1]);
        
        for(int i=2;i<n;i++)
        {
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
        }
        
        return sell[n-1];
    }
}