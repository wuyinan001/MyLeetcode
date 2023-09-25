class Solution {
    public int maxProfit(int[] prices) {
        //profit contains maximum profit if sell on day i
        //if cannot sell on day i, profit[i]=0
        int n=prices.length;
        
        if(n<=1)
            return 0;
        
        int[] profit=new int[n];
        //maximum profit
        int max=0;
        profit[0]=0;
        
        for(int i=1;i<n;i++)
        {
            profit[i]=profit[i-1]+prices[i]-prices[i-1];
            
            if(profit[i]<0)
                profit[i]=0;
            
            if(max<profit[i])
                max=profit[i];
        }
        
        return max;
    }
}